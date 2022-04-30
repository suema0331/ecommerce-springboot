package com.emacode.ecommerce.config;

import com.emacode.ecommerce.entity.Product;
import com.emacode.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

// RepositoryRestConfigurer from Spring Data REST
@Configuration // to be scanned by Spring
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        // disable Http Methods for Product: PUT POST DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                // single item
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                // collection
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction));

        // disable Http Methods for ProductCategory: PUT POST DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
    }
}
