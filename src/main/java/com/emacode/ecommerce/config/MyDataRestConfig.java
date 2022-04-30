package com.emacode.ecommerce.config;

import com.emacode.ecommerce.entity.Product;
import com.emacode.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// RepositoryRestConfigurer from Spring Data REST
@Configuration // to be scanned by Spring
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

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

        // call an internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids

        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        // create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();
        // create an array of the entities
        for (EntityType tmpEntityType: entities){
            entityClasses.add(tmpEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]); // 配列に変換
        config.exposeIdsFor(domainTypes); // domainTypesの配列を公開すると、ProductCategoryレベルのentity idを追加できる

    }
}
