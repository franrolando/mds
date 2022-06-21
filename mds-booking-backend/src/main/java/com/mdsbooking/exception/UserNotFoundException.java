package com.mdsbooking.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {
	public UserNotFoundException(String error, String reason) {
		super(error, reason, HttpStatus.BAD_REQUEST);
	}
}
