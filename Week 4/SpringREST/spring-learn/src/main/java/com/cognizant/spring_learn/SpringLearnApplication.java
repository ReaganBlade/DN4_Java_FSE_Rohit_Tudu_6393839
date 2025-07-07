package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		// Method for Hands on 2
		displayDate("31/12/2018");
	}

	// Method for Hands on 2
	public static void displayDate(String dateStr){
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
			SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
			Date date = format.parse(dateStr);
			System.out.println("Formatted Date: " + format.format(date));
		} catch (ParseException e) {
			System.err.println("Error parsing date: " + e.getMessage());
		}

	}
}
