// imports package
package com.product.productcatalog.repository;

// imports classes(libraries)
import com.product.productcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marks interface with Spring Repository annotation
@Repository
// creates CategoryRepository interface that extends from main JPA Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
