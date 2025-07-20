package com.cognizant.greet_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    
    @RequestMapping("/greet/{user}")
    private String greetUser(@PathVariable String user){
        return "Hello " + user;
    }

    @RequestMapping("/greet")
    private String greet(){
        return "Hello World";
    }

}
