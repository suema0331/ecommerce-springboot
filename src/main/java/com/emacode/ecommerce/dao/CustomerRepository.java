package com.emacode.ecommerce.dao;

import com.emacode.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


// NOT annotated hence it will not be exposed as REST API
// http://localhost:8080/api/cutomers
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Spring will execute a query similar to "SELECT * FROM Customer c WHERE c.email = theEmail"
    // is not found returns null
    Customer findByEmail(String theEmail);
}
