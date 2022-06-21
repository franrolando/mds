package com.mdsbooking.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mdsbooking.configuration.JwtUtils;
import com.mdsbooking.dto.CredentialsDTO;
import com.mdsbooking.dto.UserDTO;
import com.mdsbooking.exception.UserNotFoundException;

@Service
@Transactional
public class AuthenticationService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AuthenticationProvider authManager;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO login(CredentialsDTO credentials) {
		UserDTO user = null;
		try {
			log.info("Logging user {}", credentials.getEmail());
			UserDetails userD = (UserDetails) authManager
					.authenticate(
							new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()))
					.getPrincipal();
			user = modelMapper.map(userD, UserDTO.class);
			user.setToken(jwtUtils.getJWTToken(user.getUsername()));
			user.setRefreshToken(jwtUtils.getJWTRefreshToken(user.getUsername()));
		} catch (UserNotFoundException e) {
			log.error("Error while trying to login user {}", credentials.getEmail(), e);
		}
		return user;
	}

	public String getNewToken(String refreshToken) {
		if (jwtUtils.jwtExpired(refreshToken)) {
			log.info("Token expired");
		}
		if (jwtUtils.getClaimsFromToken(refreshToken).isEmpty()) {

		}
		return jwtUtils.getJWTRefreshToken(jwtUtils.getSubject(refreshToken));
	}

}
