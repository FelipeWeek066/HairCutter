package com.Felipe.HairCutter.resources.exceptions;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Felipe.HairCutter.entities.DTOs.StandardError;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ContentNotFoundException.class)
		public ResponseEntity<StandardError> resourceNotFound(ContentNotFoundException e, HttpServletRequest request) {
		String errorMsg = "content Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(), status.value(), errorMsg, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> resourceNotFound(DataIntegrityViolationException e, HttpServletRequest request) {
	String errorMsg = "database reference, only disable";
	HttpStatus status = HttpStatus.BAD_REQUEST;
	StandardError error = new StandardError(Instant.now(), status.value(), errorMsg, e.getMessage(), request.getRequestURI());
	return ResponseEntity.status(status).body(error);
}
}
