package com.firstspringbootproject.firstspringbootproject.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.firstspringbootproject.firstspringbootproject.execption.AadharNotFound;
import com.firstspringbootproject.firstspringbootproject.execption.UserNotFound;
import com.spring.firstspring.firstspringbootproject.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
@RestControllerAdvice
public class ExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> aadharNotFound(AadharNotFound ex){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		
		structure.setData(ex.getMessage());
		structure.setMessage("Adhar id was Not found check your id ");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFound(UserNotFound ex){
		ResponseStructure<String> structure =new ResponseStructure<String>();
		
		structure.setData(ex.getMessage());
		structure.setMessage("User id was Not found check your id ");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

	}
@org.springframework.web.bind.annotation.ExceptionHandler
	
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
	
	ResponseStructure<Object> structure =new ResponseStructure<Object>();
	Map<String,String> hash= new HashMap<String, String>();
	
	for(ConstraintViolation<?> violation: ex.getConstraintViolations())
	{
		
		String field =violation.getPropertyPath().toString();
		String message=violation.getMessage();
		hash.put(field, message);
	}
	
	structure.setData(hash);
	structure.setMessage("Add proper details");
	structure.setStatus(HttpStatus.FORBIDDEN.value());
	
	
	return new ResponseEntity<Object>(structure,HttpStatus.FORBIDDEN);
	
}
	

}
