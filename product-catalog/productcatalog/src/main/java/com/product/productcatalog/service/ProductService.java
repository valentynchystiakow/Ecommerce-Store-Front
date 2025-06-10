// imports package
package com.product.productcatalog.service;

// imports libraries(classes)
import com.product.productcatalog.model.Product;
import com.product.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// marks class with Spring Service annotation
@Service
// creates ProductService class
public class ProductService {
    // class fields
    private final ProductRepository productRepository;
    // product service constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // creates method that gets all categories from category repository(categories in database)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // creates method that gets product by certain category
    public List<Product> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
