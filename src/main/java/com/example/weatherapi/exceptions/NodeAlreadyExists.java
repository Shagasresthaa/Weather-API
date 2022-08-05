package com.example.weatherapi.exceptions;

public class NodeAlreadyExists extends Exception{

    private static final long serialVersionUID = 1L;
    
    public NodeAlreadyExists(String message) {
        super(message);
    }    
}
