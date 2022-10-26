package com.travelworking.travelworking.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
    private final Object data;
    private final Boolean status;
    
    public ApiException(String message, HttpStatus httpStatus, Object data, Boolean status) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
    public Object getData() {
        return data;
    }
    
    public Boolean getStatus() {
        return status;
    }
}
