package com.ecommerce.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;

import com.ecommerce.main.security.JWTAuthenticationFilter;
import com.ecommerce.main.security.JWTAuthorizationFilter;
import com.ecommerce.main.service.UsuarioServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UsuarioServiceImpl userService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .addFilterBefore(corsFilter(), SessionManagementFilter.class)
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilter(new JWTAuthorizationFilter(authenticationManager()))
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
