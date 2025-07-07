package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Spring REST Hands On 3 (Incorporate Loggging)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class SpringLearnApplication {

//	Spring REST Hands On 3 (Incorporate Loggging)
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		// Method for Hands on 2
		displayDate("31/12/2018");
		displayCountry();
	}

	// Method for Hands on 2
	public static void displayDate(String dateStr){

//		Spring REST Hands On 3 (Incorporate Loggging)
		LOGGER.info("Display Date: START");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
			SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
			Date date = format.parse(dateStr);
			System.out.println("Formatted Date: " + format.format(date));
		} catch (ParseException e) {
			System.err.println("Error parsing date: " + e.getMessage());
		}

//		Spring REST Hands On 3 (Incorporate Loggging)
		LOGGER.info("Display Date: END");
	}

	// Spring REST Hands on 4 displayCountry()
	public static void displayCountry(){
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
			Country country = context.getBean("country", Country.class);
			LOGGER.debug("Country: {} {}", country.getCode(), country.getName());
		} catch (Exception e) {
			LOGGER.error("Error: {}", e.getMessage());
		}
	}
}
