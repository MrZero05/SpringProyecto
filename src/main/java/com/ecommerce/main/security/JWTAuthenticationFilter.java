package com.ecommerce.main.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ecommerce.main.entities.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	 private static final Log LOG = LogFactory.getLog(JWTAuthenticationFilter.class);
		
	@Value("${spring.security.header}")
	private String HEADER ;
	
	private static final String TOKEN_BEARER_PREFIX = "Bearer ";
	
	@Value("${spring.security.secret}")
	private String SECRET;


    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = null;
        String password = null;
        try {

            Usuario user = null;

            user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            username = user.getUserNombre();
            password = user.getUserPassword();

        } catch (IOException e) {
            e.printStackTrace();
        }

        username = username.trim();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
    				FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String userName = ((User) authResult.getPrincipal()).getUsername();
        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000L))
                .signWith(SignatureAlgorithm.HS512, "clavesecreta123456").compact();

        response.addHeader("Authorization", TOKEN_BEARER_PREFIX + " " + token);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", token);
        body.put("user", authResult.getPrincipal());
        body.put("mensaje", String.format("Hola %s, has iniciado sesi�n con exito!!!", userName));

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");
    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) 
    		throws IOException, ServletException {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("mensaje", "Error de autenticaci�n: usuario o contrase�a incorrectos");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
