package com.example.weatherapi.exceptions;

public class NotAdminException extends Exception{

    private static final long serialVersionUID = 1L;

    public NotAdminException(String message){
        super(message);
    }
    
}
