package com.infy.teslapro.exception;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus
@RestControllerAdvice
public class UserNotFoundExceptionHandler 
{
	@ExceptionHandler(UserNotFoundException.class)
  public Error exceptionHandler(UserNotFoundException exception)
  {
	  Error error = new Error(exception.getMessage(),HttpStatus.NOT_FOUND);
	  return error;
  }
	
	@ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
	public Error validationExceptionHandler(Exception exception)
	{
		if(exception instanceof MethodArgumentNotValidException) {
		Error error = new Error(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		return error;
	}else {
		Error error = new Error(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		return error;}

	}
	
	@ExceptionHandler(Exception.class)
	public Error generalExceptionHandler(Exception exception)
	{
		Error error = new Error(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		return error;
	}
    
}
