package com.Employee.detials.exception;

public class Employeenotfoundexception extends RuntimeException{
    public Employeenotfoundexception(String message) {
        super(message);
    }

    public Employeenotfoundexception(String message, Throwable cause) {
        super(message, cause);
    }

}