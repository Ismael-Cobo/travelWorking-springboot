package com.travelworking.travelworking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {ApiRequestExceptions.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestExceptions e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                null,
                false
        );
        
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
