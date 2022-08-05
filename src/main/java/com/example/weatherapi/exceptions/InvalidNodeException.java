package com.example.weatherapi.exceptions;

public class InvalidNodeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidNodeException(String exp) {
        super(exp);
    }
    
}
