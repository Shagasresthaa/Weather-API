package com.example.weatherapi.exceptions;

public class InvalidEmailException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String exp) {
		super(exp);
	}

}

