package com.cognizant.greet_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    
    @GetMapping("/greet/{user}")
    private String greetUser(@PathVariable String user){
        return "Hello " + user;
    }

    @GetMapping("/greet")
    private String greet(){
        return "Hello World";
    }

}
