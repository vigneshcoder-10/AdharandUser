package com.firstspringbootproject.firstspringbootproject.execption;

public class AadharNotFound  extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public AadharNotFound(String message) {
		
		this.message = message;
	}

	

}
