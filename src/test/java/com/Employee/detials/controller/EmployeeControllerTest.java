package com.Employee.detials.controller;

import com.Employee.detials.model.Employee;
import com.Employee.detials.service.Impl.Employeeserviceimpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @Mock
    private Employeeserviceimpl employeeserviceimpl;

    @InjectMocks
    private EmployeeController employeeController;

    private Employee employee;

    private Employee secondemployee;

    private Employee thirdemployee;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {

        autoCloseable= MockitoAnnotations.openMocks(this);
        employeeController=new EmployeeController(employeeserviceimpl);
        employee=new Employee(03,"Swarna Sai Sankar",50000,5);
        secondemployee=new Employee(05,"Swarna",780000,9);
        thirdemployee=new Employee(20,"Uday",48000,5);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void postdetails() {
        String result= employeeController.postdetails(employee);

        assertEquals("Created Successfully",result);
    }

    @Test
    void updatedetials() {

        String result=employeeController.updatedetials(employee);

        assertEquals("Updated Successfully",result);
    }

    @Test
    void getdetails() {
        when(employeeserviceimpl.getdetial(employee.getId())).thenReturn(ResponseEntity.ok(employee));
        ResponseEntity<Object> result=employeeController.getdetails(03);

        assertEquals(ResponseEntity.ok(employee),result);
    }

    @Test
    void getallstudentdetails() {

        List<Employee> realempl= Arrays.asList(employee,secondemployee,thirdemployee);

        when(employeeserviceimpl.getalldetails()).thenReturn(realempl);

        List<Employee> result=employeeController.getallstudentdetails();

        assertEquals(realempl,result);

    }

    @Test
    void getsorteddetails() {
        List<Employee> realempl= Arrays.asList(employee,secondemployee,thirdemployee);
        when(employeeserviceimpl.getsorteddetails()).thenReturn(realempl);

        List<Employee> result= employeeController.getsorteddetails();
    }

    @Test
    void deletedetails() {
        String result= employeeController.deletedetails(employee.getId());
        assertEquals("Details Deleted Successfully",result);
    }
}