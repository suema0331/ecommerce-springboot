package com.emacode.ecommerce.dao;

import com.emacode.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



// we don't need because MyDataRestConfig can set cors global setting for all repositories
//@CrossOrigin("http://localhost:4200")

// If we choose "ANNOTATED" strategies
// Only repositories with @RepositoryRestResource are exposes
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
