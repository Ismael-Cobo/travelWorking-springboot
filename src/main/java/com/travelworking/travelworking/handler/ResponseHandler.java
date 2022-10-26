package com.travelworking.travelworking.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(
            String message,
            HttpStatus httpStatus,
            Object responseObject,
            Boolean status
    ) {
    
        Map<String, Object> map = new HashMap<>();
        
        map.put("message", message);
        map.put("httpStatus", httpStatus.value());
        map.put("data", responseObject);
        map.put("ok", status);
        
        return new ResponseEntity<>(map, httpStatus);
    }

}
