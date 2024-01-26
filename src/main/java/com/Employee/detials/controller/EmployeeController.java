package com.Employee.detials.controller;

import com.Employee.detials.model.Employee;
import com.Employee.detials.service.Impl.Employeeserviceimpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    Employeeserviceimpl employeeserviceimpl;

    public EmployeeController(Employeeserviceimpl employeeserviceimpl) {
        this.employeeserviceimpl = employeeserviceimpl;
    }

    @PostMapping
    public String postdetails(@RequestBody Employee employee){
        employeeserviceimpl.createdetials(employee);
        return "Created Successfully";
    }

    @PutMapping
    public String updatedetials(@RequestBody Employee employee){
        employeeserviceimpl.updatedetails(employee);
        return "Updated Successfully";
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getdetails(@PathVariable("id") Integer id){
        return employeeserviceimpl.getdetial(id);
    }

    @GetMapping()
    public List<Employee> getallstudentdetails(){
        return employeeserviceimpl.getalldetails();
    }

    @GetMapping("/soreted")
    public List<Employee> getsorteddetails(){
        return employeeserviceimpl.getsorteddetails();
    }

    @DeleteMapping("{id}")
    public String deletedetails(@PathVariable("id") Integer id){
        employeeserviceimpl.deletedetails(id);
        return "Details Deleted Successfully";
    }
}
