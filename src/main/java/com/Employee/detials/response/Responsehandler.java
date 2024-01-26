package com.Employee.detials.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Responsehandler {
    public static ResponseEntity<Object> res(String message, HttpStatus httpStatus, Object object){
        Map<String, Object> responsehandle=new HashMap<>();
        responsehandle.put("Message", message);
        responsehandle.put("HttpStatus",httpStatus);
        responsehandle.put("Data", object);

        return new ResponseEntity<>(responsehandle,httpStatus);
    }
}