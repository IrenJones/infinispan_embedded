package com.epam.infinispan.embedded.services;

import com.epam.infinispan.embedded.repositories.CountryRepository;
import com.epam.infinispan.embedded.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @CacheEvict(value = "countriesCache", key = "#p0.id")
    public Country save(Country toSave){
        return countryRepository.save(toSave);
    }

    @Cacheable(value="countriesCache",key="#id",unless="#result==null")
    public Country getById(Integer id) {
        return countryRepository.findOne(id);
    }

    @CacheEvict(value="countriesCache",key="#id")
    public void delete(Integer id) {
        countryRepository.delete(id);
    }

    @CachePut(value="countriesCache",key="#country.id")
    public Country update(Country country) {
        Country updatedCountry = null;
        Country countryFromDb = countryRepository.findOne(country.getId());
        if(countryFromDb != null){
            countryFromDb.setName(country.getName());
            countryFromDb.setPopulation(country.getPopulation());
            countryFromDb.setLanguage(country.getLanguage());
            countryFromDb.setRegistrationDate(country.getRegistrationDate());
            updatedCountry = countryRepository.save(countryFromDb);
        }
        return updatedCountry;
    }
}
