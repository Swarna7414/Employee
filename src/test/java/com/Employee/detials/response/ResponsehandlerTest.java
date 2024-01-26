package com.Employee.detials.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponsehandlerTest {

    @Test
    public void responsiblehandler(){

        String message="Test Message";
        HttpStatus httpStatus=HttpStatus.OK;
        Object object=new Object();

        ResponseEntity<Object> responseEntity= Responsehandler.res(message,httpStatus,object);

    }
}