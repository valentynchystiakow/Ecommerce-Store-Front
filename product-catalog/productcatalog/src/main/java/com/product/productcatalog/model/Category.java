// imports package
package com.product.productcatalog.model;

// imports classes(libraries)
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Set;

// marks class as Spring JPA Entity and Lombok Data
@Entity
@Data
// create Category model class
public class Category {
    //class fields
    // marks class as primary id with Identity Generation Type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // creates relationship between Category and Product entities
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;


}
