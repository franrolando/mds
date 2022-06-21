package com.mdsbooking.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mdsbooking.service.UserService;

@Configuration
@EnableWebSecurity
@Profile("prod")
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity, JwtAuthorizationFilter jwtAuthorizationFilter,
			UserService userDetailsService, DaoAuthenticationProvider provider,
			AuthenticationManager authenticationManager) throws Exception {
		httpSecurity.csrf().disable().cors().and()
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.authenticationProvider(provider).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
		return httpSecurity.build();
	}

	@Bean
	public RequestMatcher requestMatcher() {
		List<RequestMatcher> pathsMatcher = new ArrayList<>();
		pathsMatcher.add(new AntPathRequestMatcher("/user"));
		pathsMatcher.add(new AntPathRequestMatcher("/booking", HttpMethod.POST.name()));
		pathsMatcher.add(new AntPathRequestMatcher("/house", HttpMethod.POST.name()));
		pathsMatcher.add(new AntPathRequestMatcher("/inquiry"));
		pathsMatcher.add(new AntPathRequestMatcher("/house/findById"));
		
		RequestMatcher requestMatcher = new OrRequestMatcher(pathsMatcher);
		return requestMatcher;
	}

}
