package com.cognizant.Spring_Employee_Form.model;

import java.util.Date;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private boolean permanent;
    private Date dateOfBirth;
    private Department department;
    private List<Skill> skillList;

    public Employee() {}

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }
}
