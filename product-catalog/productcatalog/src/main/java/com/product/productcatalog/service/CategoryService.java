// imports package
package com.product.productcatalog.service;

// imports libraries(classes)
import com.product.productcatalog.model.Category;
import com.product.productcatalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// marks class with Spring Service annotation
@Service
// creates CategoryService class
public class CategoryService {
    // class fields
    private final CategoryRepository categoryRepository;
    // category service constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // creates method that gets all categories from category repository(categories in database)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
