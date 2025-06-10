// imports package
package com.product.productcatalog;

// imports classes(libraries)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// marks class as main Spring Boot Application
@SpringBootApplication
// creates main class that runs program
public class ProductcatalogApplication {
	// creates method that runs program
	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

}
