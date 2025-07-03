package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args); // ✅ No need to get bean manually
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Application Started");
		testGetAllCountries(); // ✅ Now countryService is injected properly
	}

	private void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
}
