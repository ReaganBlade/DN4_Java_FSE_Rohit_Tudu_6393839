package com.cognizant.Spring_Employee_Form.model;

public class Skill {
    private int id;
    private String name;

    public Skill() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
