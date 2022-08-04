package com.example.weatherapi.exceptions;

public class EmptyFieldException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyFieldException(String exp) {
		super(exp);
	}

}

