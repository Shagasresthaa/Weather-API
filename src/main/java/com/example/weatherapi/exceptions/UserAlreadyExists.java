package com.example.weatherapi.exceptions;

public class UserAlreadyExists extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UserAlreadyExists(String exp) {
        super(exp);
    }
    
}
