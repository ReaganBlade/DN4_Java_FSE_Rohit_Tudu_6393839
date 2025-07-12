package com.cognizant.Spring_Employee_Form.dao;

import com.cognizant.Spring_Employee_Form.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDAO {
    private static ArrayList<Employee> employeeList;

    public EmployeeDAO() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        employeeList = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }
}
