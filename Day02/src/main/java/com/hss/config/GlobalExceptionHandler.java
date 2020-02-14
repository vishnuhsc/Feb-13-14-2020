package com.hss.config;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.hss.exceptions.AccountNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInformation> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setMessage(ex.getMessage());
		errorInformation.setTimestamp(LocalDateTime.now());
		errorInformation.setPath(request.getDescription(false));
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorInformation> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, 
			WebRequest request) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setMessage(ex.getMessage());
		errorInformation.setTimestamp(LocalDateTime.now());
		errorInformation.setPath(request.getDescription(false));
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorInformation> handleAccountNotFoundException(AccountNotFoundException ex, 
			WebRequest request) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setMessage(ex.getMessage());
		errorInformation.setTimestamp(LocalDateTime.now());
		errorInformation.setPath(request.getDescription(false));
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
}










