package com.Employee.detials.service.Impl;

import com.Employee.detials.Repository.EmployeeRepository;
import com.Employee.detials.exception.Employeenotfoundexception;
import com.Employee.detials.model.Employee;
import com.Employee.detials.service.employeeservice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeserviceimplTest {

    @Mock
    private EmployeeRepository employeeRepository;


    private employeeservice employeservice;
    private Employee employee;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        employeservice=new Employeeserviceimpl(employeeRepository);
        employee= new Employee(03,"Swarna Sai Sankar",5000,5);

    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createdetials() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeservice.createdetials(employee)).isEqualTo("Successfully created");
    }

    @Test
    void updatedetails() {

        Integer empid=5;
        // Arrange
        Employee updatedEmployee = new Employee(5, "UdaySankar", 90000, 6);

        // Mock the behavior of your repository
        when(employeeRepository.findById(empid)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);

        // Act
        String result = employeservice.updatedetails(updatedEmployee);

        // Assert
        assertThat(result).isEqualTo("Information Updated Successfully");
        assertEquals("UdaySankar", employee.getName());
        assertEquals(90000, employee.getSalary());
        assertEquals(6, employee.getExperience());
    }
    @Test
    void getdetial() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        Integer exisingvalue=03;
        when(employeeRepository.findById(exisingvalue)).thenReturn(Optional.ofNullable(employee));

        Integer notexisted=66;
        when(employeeRepository.findById(notexisted)).thenReturn(Optional.empty());

        ResponseEntity<Object> responseforexisted=employeservice.getdetial(exisingvalue);
        assertThat(responseforexisted.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseforexisted.getBody()).isNotNull();

        Employeenotfoundexception employeenotfoundexception=assertThrows(Employeenotfoundexception.class, () -> employeservice.getdetial(notexisted));
        assertThat(employeenotfoundexception.getMessage()).isEqualTo("Sorry bro not found");
    }

    @Test
    void getalldetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        Employee employee1=new Employee(1,"Swarna",5000,5);
        Employee employee2=new Employee(2,"hari",5000000,6);

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1,employee2));

        List<Employee> alldetials = employeservice.getalldetails();

        assertThat(alldetials).isNotNull();

        assertThat(alldetials.get(0).getName()).isEqualTo("Swarna");
        assertThat(alldetials.get(1).getExperience()).isEqualTo(6);

    }

    @Test
    void getsorteddetails() {

        mock(EmployeeRepository.class);

        Employee employee1=new Employee(20,"swarna",45000,3);
        Employee employee2=new Employee(50,"Sai",650000000,6);
        Employee employee3=new Employee(65,"Sankar",870000,9);

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1,employee3,employee2));

        List<Employee> result= employeservice.getsorteddetails();

        assertEquals(2,result.size());
    }

    @Test
    void deletedetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.ofNullable(employee));

        String result= employeservice.deletedetails(employee.getId());

    }
}