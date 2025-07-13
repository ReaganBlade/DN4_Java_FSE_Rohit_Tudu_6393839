# Spring Boot REST Hands-On

This repository contains hands-on implementations of various Spring Boot and Spring Core concepts including dependency injection, RESTful web services, and logging.

---

## 📘 Prerequisites

* Java 8 or higher
* Maven 3.x
* Spring Boot (recommended version: 2.x)
* IDE: Eclipse / IntelliJ / VS Code
* Postman or cURL for REST testing

---

## 📂 Project Structure

```
spring-learn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/springlearn/...
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── country.xml
│   │       └── date-format.xml
│   └── test/
│       └── java/
│           └── com/cognizant/springlearn/...
├── pom.xml
└── README.md
```

---

## 🧪 Hands-On Tasks

### ✅ 1. Spring Boot Setup

* Created a Spring Boot application using Spring Initializr.
* Enabled `@SpringBootApplication` and ran the main class.
* Verified the setup via logs.
* Familiarized with project structure and dependencies via `pom.xml`.

### ✅ 2. Dependency Injection with XML

* Configured a `SimpleDateFormat` bean using `date-format.xml`.
* Loaded bean using `ClassPathXmlApplicationContext`.
* Parsed date string `31/12/2018` using the injected bean.

### ✅ 3. Logging Setup

* Configured `application.properties` for logging format and levels.
* Integrated SLF4J with `LoggerFactory`.
* Replaced all `System.out.println()` statements with proper logs.

### ✅ 4. Country Bean Configuration

* Defined a `Country` bean in `country.xml`.
* Added logging in constructor, setters, and getters.
* Used `ApplicationContext` to load and print country info.

### ✅ 5. Bean Scopes

* Demonstrated **Singleton Scope** (default): multiple calls return same object.
* Demonstrated **Prototype Scope**: multiple calls return different objects.

### ✅ 6. Collection Injection

* Defined multiple country beans and added to a `List` bean (`countryList`).
* Loaded and printed the list of countries from Spring XML.

---

## 🌐 RESTful Web Services

### ✅ 7. Hello World Service

* URL: `/hello`
* Returns: `"Hello World!!"`
* Verified using browser and Postman.

### ✅ 8. Get Country Info

* URL: `/country`
* Returns: JSON of `India` bean loaded from Spring config.

### ✅ 9. Get All Countries

* URL: `/countries`
* Returns: JSON list of all countries from `countryList` bean.

### ✅ 10. Get Country by Code

* URL: `/countries/{code}`
* Logic: Case-insensitive match from country list.
* Returns: Country object as JSON.

### ✅ 11. Exception Handling

* URL: `/countries/{invalid_code}`
* Throws custom `CountryNotFoundException`.
* Returns: 404 JSON error with message `"Country not found"`.

---

## 🔗 References

* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Spring Core - Beans and IoC](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
* [Spring REST Guide](https://spring.io/guides/gs/rest-service/)

---

## ✍️ Author

Rohit Tudu
(Cognizant Spring Boot Hands-on Submission)
