package com.travelworking.travelworking.exceptions;

public class NoSuchTrabajoExistsException extends RuntimeException{
    private String message;
    
    public NoSuchTrabajoExistsException() {}
    
    public NoSuchTrabajoExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
