package com.mdsbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.UserDTO;
import com.mdsbooking.dto.UserProfileDTO;
import com.mdsbooking.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController<UserService> {

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
		userDto = classService.createUser(userDto);
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
		return new ResponseEntity<>(classService.findByEmail(email), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> modifyUserProfile(@RequestBody UserProfileDTO profile){
		return new ResponseEntity<>(classService.updateProfile(profile), HttpStatus.OK);
	}

}
