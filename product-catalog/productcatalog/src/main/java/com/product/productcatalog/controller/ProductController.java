// imports package
package com.product.productcatalog.controller;

// imports libraries(classes)
import com.product.productcatalog.model.Product;
import com.product.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// marks class as Rest Controller and Request Mapping in order to process requests to api endpoints
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
// creates ProductController class
public class ProductController {
    // class fields
    private final ProductService productService;
    // creates category controller constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // marks method with getMapping annotation for get request to endpoint
    @GetMapping
    // creates method that makes request to get all categories
    public List<Product> getAllProducts () {
        return productService.getAllProducts();
    }

    // marks method with getMapping annotation for get request to endpoint
    @GetMapping("/category/{categoryId}")
    // creates method that makes request to get products by certain category
    public List<Product> getAllProductsByCategory (@PathVariable  Long categoryId) {
        return productService.getProductByCategory(categoryId);
    }
}
