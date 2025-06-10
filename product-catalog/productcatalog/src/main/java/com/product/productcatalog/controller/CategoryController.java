// imports package
package com.product.productcatalog.controller;


// imports classes(libraries)
import com.product.productcatalog.model.Category;
import com.product.productcatalog.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// marks class as Rest Controller and Request Mapping in order to process requests to api endpoints
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173/")
// creates category controller class
public class CategoryController {
    // class fields
    private final CategoryService categoryService;
    // creates category controller constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    // marks method with getMapping annotation for get request to endpoint
    @GetMapping
    // creates method that makes request to get all categories
    public List<Category> getAllCategories () {
        return categoryService.getAllCategories();
    }

}
