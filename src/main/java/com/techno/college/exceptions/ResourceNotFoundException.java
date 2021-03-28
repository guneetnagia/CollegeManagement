package com.techno.college.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8717343888954982282L;
	
	public ResourceNotFoundException(){
		super("Resource Not Found.");
	}
	
	public String getMessage(){
		return "Resource Not Found.";
	}

}
