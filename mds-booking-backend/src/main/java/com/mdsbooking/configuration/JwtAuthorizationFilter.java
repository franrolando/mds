package com.mdsbooking.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
@Profile("prod")
public class JwtAuthorizationFilter extends AbstractAuthenticationProcessingFilter implements Filter {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String HEADER = "Authorization";

	@Autowired
	private JwtUtils jwtUtils;

	protected JwtAuthorizationFilter(RequestMatcher requiresAuthenticationRequestMatcher, AuthenticationManager authenticationManager) {
		super(requiresAuthenticationRequestMatcher, authenticationManager);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		try {
			if (!this.requiresAuthentication(req, resp)) {
				chain.doFilter(request, response);
			} else {
				String authHeader = req.getHeader(HEADER);
				if (authHeader != null && !authHeader.isEmpty() && !authHeader.isBlank()) {
					if (jwtUtils.existeJWTToken(authHeader)) {
						Claims claims = jwtUtils.getClaimsFromToken(authHeader);
						jwtUtils.setUpSpringAuthentication(claims);
						chain.doFilter(request, response);
					}
				} else {
					throw new MalformedJwtException("JWT is not present in request");
				}
			}
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			log.error("Error", e);
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		return null;
	}

}
