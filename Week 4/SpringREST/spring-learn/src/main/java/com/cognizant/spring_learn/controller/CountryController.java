package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    // Mandatory Hands On REST - Country Web Service
    @RequestMapping("/india")
    public Country getCountry(){
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country.xml")) {
            return context.getBean("in", Country.class);
        } catch (Exception e) {
            return null;
        }
    }

    // Hands on REST - Get all countries
    @RequestMapping("/countries")
    public Country[] getCountries(){
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country.xml")) {
            return context.getBeansOfType(Country.class).values().toArray(new Country[0]);
        } catch (Exception e) {
            return null;
        }
    }

    // Hands on REST - Get country based on country code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code){
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country.xml")) {
            return context.getBean(code, Country.class);
        } catch (Exception e) {
            return null;
        }
    }


//    @RequestMapping("/{country}")
//    public Country getCountry(@PathVariable String country){
//        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
//            return context.getBean(country, Country.class);
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
