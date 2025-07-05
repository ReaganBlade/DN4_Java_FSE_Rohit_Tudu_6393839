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
		SpringApplication.run(OrmLearnApplication.class, args);

		// ✅ No need to get bean manually
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Application Started");
		testGetAllCountries(); // ✅ Now countryService is injected properly
		testGetCountryByCode();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		testGetPartialMatches();
	}

	// Testing all the methods

	private void testGetAllCountries() {
		LOGGER.info("Testing Get All Countries....");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("Get All Countries Test Completed.");
	}

	private void testGetCountryByCode(){
		LOGGER.info("Testing Get Country By Code....");
		Country country = countryService.getCountryByCode("IN");
		LOGGER.debug("country={}", country);
		LOGGER.info("Get Country By Code Test Completed.");
	}

	private void testAddCountry(){
		LOGGER.info("Testing Add Country....");
		Country country = new Country("JP", "Japan");
		countryService.addCountry(country);
		LOGGER.info("Add Country Test Completed.");
	}

	private void testUpdateCountry(){
		LOGGER.info("Testing Update Country....");
		Country country = new Country("IN", "Updated India");
		countryService.updateCountry(country);
		LOGGER.info("Update Country Test Completed.");
	}

	private void testDeleteCountry(){
		LOGGER.info("Testing Delete Country....");
		countryService.deleteCountry("UN");
		LOGGER.info("Delete Country Test Completed.");
	}

	private void testGetPartialMatches(){
		LOGGER.info("Testing Get Partial Matches....");
		List<Country> partialMatches = countryService.getPartialMatches("ind");
		LOGGER.debug("countries={}", partialMatches);
		LOGGER.info("Get Partial Matches Test Completed.");
	}
}
