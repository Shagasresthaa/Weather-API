package com.example.weatherapi.exceptions;

public class DataNotDeletedException extends Exception{

    private static final long serialVersionUID = 1L;

    public DataNotDeletedException(String message){
        super(message);
    }
    
}
