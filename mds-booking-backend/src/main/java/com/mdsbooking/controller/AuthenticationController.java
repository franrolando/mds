package com.mdsbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.CredentialsDTO;
import com.mdsbooking.dto.UserDTO;
import com.mdsbooking.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;
	
	@PostMapping
	public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentials) {
		return new ResponseEntity<>(authService.login(credentials), HttpStatus.OK);		
	}
	
	@PutMapping
	public ResponseEntity<String> getNewToken(@RequestBody String refreshToken){
		return new ResponseEntity<>(authService.getNewToken(refreshToken), HttpStatus.OK);
	}
	
	
}
