// imports package
package com.product.productcatalog.config;

// imports classes(libraries)
import com.product.productcatalog.model.Category;
import com.product.productcatalog.model.Product;
import com.product.productcatalog.repository.CategoryRepository;
import com.product.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// marks class with Spring Component annotation
@Component
// creates DataSeeder class
public class DataSeeder implements CommandLineRunner {
    // class fields
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // creates product and category repositories constructors
    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // overrides class method that runs when app is starting
    @Override
    public void run(String... args) throws Exception {
        // clear all existing data in repositories
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // creates Categories fields
        // Electronics category field
        Category electronics = new Category();
        electronics.setName("Electronics");

        // Clothing category field
        Category clothing = new Category();
        clothing.setName("Clothing");

        // Home category field
        Category home = new Category();
        home.setName("Home and Kitchen");

        // saves created categories in repository
        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        // creates Products fields
        // Phone product field
        Product phone = new Product();
        phone.setName("Iphone 16 Plus");
        phone.setDescription("Latest mode iphone with amazing features. Ultramarine color, 512 gb of memory capacity");
        phone.setImageUrl("https://imag.ua/image/cache/catalog/products/iPhone/iPhone%2016/Ultramarine/42244.750-600x400h.png");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        // Laptop product field
        Product laptop = new Product();
        laptop.setName("MacBook Air 13 M1");
        laptop.setDescription("High performance laptop for work and play");
        laptop.setImageUrl("https://imag.ua/image/cache/catalog/products/MacBook/MacBook%20Air%20M1/Gold/1-600x400h.png");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        // Jacket product field
        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and Cozy jacket for winter");
        jacket.setImageUrl("https://www.shutterstock.com/image-illustration/down-jacket-mockup-3d-render-600nw-2482699815.jpg");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);

        // Blender product field
        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies");
        blender.setImageUrl("https://www.shutterstock.com/image-photo/sao-paulo-brazil-december-27-600nw-2564906637.jpg");
        blender.setPrice(89.99);
        blender.setCategory(home);

        // saves creates products to product repository
        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));

    }
}
