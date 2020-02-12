package com.ecommerce.main.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private static final Log LOG = LogFactory.getLog(JWTAuthorizationFilter.class);
	private static final String HEADER_AUTHORIZACION_KEY = "token";
	private static final String PREFIX = "Bearer";
	private static final String SECRET_KEY = "clavesecreta123456";
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info(PREFIX);
		String header = request.getHeader(HEADER_AUTHORIZACION_KEY);
		if (header == null || !header.startsWith(PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken auth = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);
		if (token != null) {
			String tokenReceive = token.replace(PREFIX+" ", "");
			String user = Jwts.parser()
						.setSigningKey(SECRET_KEY)
						.parseClaimsJws(token.replace(tokenReceive, ""))
						.getBody()
						.getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			return null;
		}
		return null;
	}
}
