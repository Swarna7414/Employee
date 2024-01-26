package com.Employee.detials.service.Impl;

import com.Employee.detials.Repository.EmployeeRepository;
import com.Employee.detials.exception.Employeenotfoundexception;
import com.Employee.detials.model.Employee;
import com.Employee.detials.response.Responsehandler;
import com.Employee.detials.service.employeeservice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Employeeserviceimpl implements employeeservice {


    EmployeeRepository employeeRepository;

    @Autowired
    public Employeeserviceimpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String createdetials(Employee employee) {
        employeeRepository.save(employee);
        return "Successfully created";
    }

    @Override
    public String updatedetails(Employee updatedemployee) {
        Integer id=updatedemployee.getId();
        Employee existingemployee=employeeRepository.findById(id).orElseThrow(()-> new Employeenotfoundexception("Employee ID not found"));

        existingemployee.setName(updatedemployee.getName());
        existingemployee.setSalary(updatedemployee.getSalary());
        existingemployee.setExperience(updatedemployee.getExperience());

        employeeRepository.save(existingemployee);

        return "Information Updated Successfully";
    }

    @Override
    public ResponseEntity<Object> getdetial(Integer id) {

        if(employeeRepository.findById(id).isEmpty()){
            throw new Employeenotfoundexception("Sorry bro not found");
        }

        return Responsehandler.res("details found",HttpStatus.OK,employeeRepository.findById(id).get());
    }
    @Override
    public List<Employee> getalldetails() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getsorteddetails(){
        List<Employee> sorted=employeeRepository.findAll();
        return sorted.stream().filter(n->n.getSalary()>=50000).collect(Collectors.toList());
    }

    @Override
    public String deletedetails(Integer id) {
        employeeRepository.deleteById(id);
        return "Deleted Successfully";
    }

}
