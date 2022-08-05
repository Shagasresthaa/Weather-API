package com.example.weatherapi.exceptions;

public class NodeNotActiveException extends Exception{
    
        /**
        * 
        */
        private static final long serialVersionUID = 1L;
    
        public NodeNotActiveException(String exp) {
            super(exp);
        }

}
