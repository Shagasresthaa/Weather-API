package com.example.weatherapi.exceptions;

public class InvalidAuthenticationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAuthenticationException(String exp) {
		super(exp);
	}

}

