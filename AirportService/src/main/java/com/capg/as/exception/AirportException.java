package com.capg.as.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AirportException extends Exception
{
private static final long serialVersionUID = 1L;
@ExceptionHandler(value={AirportNotFoundException.class })
	public ResponseEntity<Object> exception(AirportNotFoundException exception)
	{
	      return new ResponseEntity<>("Airport not found", HttpStatus.NOT_FOUND);
	}
}

