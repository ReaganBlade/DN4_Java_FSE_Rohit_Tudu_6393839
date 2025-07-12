package com.cognizant.Spring_Employee_Form.controller;

import com.cognizant.Spring_Employee_Form.model.Employee;
import com.cognizant.Spring_Employee_Form.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeebyId(@PathVariable int id){
        return employeeService.getAllEmployees().stream()
            .filter(emp -> emp.getId() == id)
            .findFirst()
            .orElse(() -> new ResponseStatusException(
                    NOT_FOUND, "Employee not found with id: " + id
            ));
    }


}
