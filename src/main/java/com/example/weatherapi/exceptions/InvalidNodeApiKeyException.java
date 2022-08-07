package com.example.weatherapi.exceptions;

public class InvalidNodeApiKeyException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public InvalidNodeApiKeyException(String message) {
        super(message);
    }
} 
