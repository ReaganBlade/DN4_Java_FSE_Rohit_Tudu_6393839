package com.library.LibraryManagement;

import com.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BookService bookService = (BookService) context.getBean("bookService");
		bookService.addBook("The Great Gatsby");
	}

}
