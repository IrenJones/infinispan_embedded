package com.epam.infinispan.embedded.controllers;

import com.epam.infinispan.embedded.services.CountryService;
import com.epam.infinispan.embedded.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping(value="/country")
    public Country create(@RequestBody Country country){
        return countryService.save(country);
    }

    @GetMapping(value="/country/{countryId}")
    public Country getById(@PathVariable("countryId")Integer countryId){
        return countryService.getById(countryId);
    }

    @DeleteMapping(value="/country/{countryId}")
    public void delete(@PathVariable("countryId")Integer countryId){
        countryService.delete(countryId);
    }

    @PutMapping(value="/country")
    public Country update(@RequestBody Country country){
        return countryService.update(country);
    }
}
