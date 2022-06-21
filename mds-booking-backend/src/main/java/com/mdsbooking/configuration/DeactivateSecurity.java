package com.mdsbooking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.mdsbooking.service.UserService;

@Profile("test")
@Configuration
@EnableWebSecurity
public class DeactivateSecurity {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity, UserService userDetailsService,
			DaoAuthenticationProvider provider, AuthenticationManager authenticationManager) throws Exception {
		httpSecurity.csrf().disable().cors().and().authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
				.authenticationProvider(provider).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
		return httpSecurity.build();
	}
}