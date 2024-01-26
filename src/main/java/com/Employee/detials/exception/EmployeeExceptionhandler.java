package com.Employee.detials.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionhandler {

    @ExceptionHandler(value = Employeenotfoundexception.class)
    public ResponseEntity<Object> exceptionhandler(Employeenotfoundexception employeenotfoundexception){
        EmployeeException employeeException=new EmployeeException(
                employeenotfoundexception.getMessage(),
                employeenotfoundexception.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(employeeException,HttpStatus.NOT_FOUND);
    }
}
