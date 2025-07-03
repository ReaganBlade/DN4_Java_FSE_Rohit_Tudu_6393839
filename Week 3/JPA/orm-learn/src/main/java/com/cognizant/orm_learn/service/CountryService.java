package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @Transactional
    public Country getCountryById(String CountryCode){
        Optional<Country> country = countryRepository.findById(CountryCode);
        return country.orElse(null);
    }

    @Transactional
    public List<Country> getCountriesByPart(String part){
        List<Country> countries = countryRepository.findByNameContaining(part);

        return countries;
    }

}
