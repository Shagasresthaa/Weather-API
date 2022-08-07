package com.example.weatherapi.exceptions;

public class InvalidUserApiKeyException extends Exception{

    private static final long serialVersionUID = 1L;

    public InvalidUserApiKeyException(String message) {
        super(message);
    }
    
}
