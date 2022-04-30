package com.emacode.ecommerce.dao;

import com.emacode.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// provide the name of JSON entry for the collection resource relationship.
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category") // /product-category
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> { //  <Entity, PrimaryKey>

}
