// imports package
package com.product.productcatalog.model;

// imports classes(libraries)
import jakarta.persistence.*;
import lombok.Data;

//creates Product model class
@Entity
@Data
public class Product {
    // marks field as primary id with generated identity type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    // creates relationship between Category and Product entity
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
}
