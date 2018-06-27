package com.epam.infinispan.embedded.repositories;

import com.epam.infinispan.embedded.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
