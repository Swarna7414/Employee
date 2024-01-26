package com.Employee.detials.service;

import com.Employee.detials.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface employeeservice {

    public String createdetials(Employee employee);

    public String updatedetails(Employee employee);

    public ResponseEntity<Object> getdetial(Integer id);

    public List<Employee> getalldetails();

    public List<Employee> getsorteddetails();

    public String deletedetails(Integer id);

}