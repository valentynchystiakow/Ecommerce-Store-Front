// imports package
package com.product.productcatalog.repository;

// imports classes(libraries)
import com.product.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// marks interface with Spring Repository annotation
@Repository
// creates ProductRepository interface that implements JPA repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // creates method that product by category id
    List<Product> findByCategoryId(Long categoryId);
}
