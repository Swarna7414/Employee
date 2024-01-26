package com.Employee.detials.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeExceptionTest {

    private String message="gotcha error";

    private Throwable throwable= new RuntimeException("got error");

    HttpStatus status=HttpStatus.NOT_FOUND;

    @Test
    public void testemployeeexception(){
        EmployeeException employeeException=new EmployeeException(message,throwable,status);

        employeeException.getMessage();
        employeeException.getThrowable();
        employeeException.getHttpStatus();
    }
}