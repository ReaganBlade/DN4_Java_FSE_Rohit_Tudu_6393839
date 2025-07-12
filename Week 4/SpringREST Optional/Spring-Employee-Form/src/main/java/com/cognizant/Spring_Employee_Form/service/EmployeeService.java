package com.cognizant.Spring_Employee_Form.service;

import com.cognizant.Spring_Employee_Form.dao.EmployeeDAO;
import com.cognizant.Spring_Employee_Form.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

}
