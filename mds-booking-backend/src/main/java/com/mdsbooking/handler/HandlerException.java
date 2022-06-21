package com.mdsbooking.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mdsbooking.exception.CustomException;
import com.mdsbooking.response.ExceptionResponse;

@ControllerAdvice
public class HandlerException {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> handleCustomException(CustomException e, HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(e.getStatus());
		response.setError(e.getError());
		response.setReason(e.getReason());
		response.setTimestamp(e.getTimestamp());
		response.setPath(request.getRequestURI());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleCustomException(Exception e, HttpServletRequest request) {
		log.error("Unknow error: {} ", e);
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setError("Unknow error");
		response.setReason("An unexpected error happen");
		response.setTimestamp(LocalDateTime.now());
		response.setPath(request.getRequestURI());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public ResponseEntity<ExceptionResponse> handleCustomException(InternalAuthenticationServiceException e,
			HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(HttpStatus.UNAUTHORIZED);
		response.setError("User not found");
		response.setReason("User credentials not found on database");
		response.setTimestamp(LocalDateTime.now());
		response.setPath(request.getRequestURI());
		return new ResponseEntity<>(response, response.getStatus());
	}

}
