package com.mdsbooking.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {

	private LocalDateTime timestamp;
	private HttpStatus status;
	private String error;
	private String reason;
	private String path;
	
	public CustomException(String error, String reason, HttpStatus status) {
		this.status = status;
		this.error = error;
		this.reason = reason;
		this.timestamp = LocalDateTime.now();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
