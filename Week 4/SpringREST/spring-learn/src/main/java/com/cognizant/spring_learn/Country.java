// For Spring REST Hands on 4 (Entire Country File)

package com.cognizant.spring_learn;

import static com.cognizant.spring_learn.SpringLearnApplication.LOGGER;

public class Country {

    public Country(){
        LOGGER.debug("Inside Country Constructor");
    }

    private String code;
    private String name;

    public Country(String code, String name){
        this.code = code;
        this.name = name;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %s", code, name);
    }
}
