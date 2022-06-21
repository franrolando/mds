package com.mdsbooking.configuration;

import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private static final int MILLISECONDS_MINUTE = 60000;
	private static String SECRET_KEY = "mds-key";
	private final String PREFIX = "Bearer ";

	public String getJWTToken(String username) {
		return getJWTToken(username, 10 * MILLISECONDS_MINUTE);
	}

	public String getJWTRefreshToken(String username) {
		return getJWTToken(username, 60 * MILLISECONDS_MINUTE);
	}

	private String getJWTToken(String username, long duration) {
		String token = Jwts.builder().setId("mdsJWT").setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + duration))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes()).compact();
		return token;
	}

	public Claims getClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token.replace(PREFIX, "")).getBody();
	}

	public String getSubject(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean jwtExpired(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody().getExpiration()
				.before(new Date());
	}

	public void setUpSpringAuthentication(Claims claims) {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				null);
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	public boolean existeJWTToken(String header) {
		if (header == null || !header.startsWith(PREFIX))
			return false;
		return true;
	}

}
