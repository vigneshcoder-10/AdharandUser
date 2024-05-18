package com.firstspringbootproject.firstspringbootproject.execption;

public class UserNotFound extends RuntimeException {

	
	String message;
	
	public UserNotFound(String message)
	{
		this.message=message;
	}
	
	public String getMessage()
	{
		return message;
	}
	}

