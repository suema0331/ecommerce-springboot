package com.emacode.ecommerce.dao;

import com.emacode.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> { //  <Entity, PrimaryKey>

    // findByCategoryId: QueryMethod match by categoryId and use this parameter value("id")
    // Spring will execute a query "SELECT *  FROM product where category_id = ??"
    // Spring Data REST automatically exposes the endpoints http://localhost:8080/api/products/search/findByCategoryId?id=4
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

}
