package com.example.weatherapi.exceptions;

public class UserNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String exp) {
		super(exp);
	}

}

