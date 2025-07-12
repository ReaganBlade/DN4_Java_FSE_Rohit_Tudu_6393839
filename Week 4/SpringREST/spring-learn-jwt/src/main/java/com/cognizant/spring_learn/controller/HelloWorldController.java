// For Hands on - Hello World RESTful Web Service
package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
