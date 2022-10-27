package com.travelworking.travelworking.exceptions;

public class NoSuchIdiomaExistsException extends RuntimeException{
    private String message;
    
    public NoSuchIdiomaExistsException() {}
    
    public NoSuchIdiomaExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
