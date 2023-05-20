package com.pack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.pack.dao.Response;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
	public ResponseEntity<Response> exceptionHandler(RuntimeException ex)
	{
		return new ResponseEntity<>(
				new Response(
						HttpStatus.BAD_REQUEST.value(),
						ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}
