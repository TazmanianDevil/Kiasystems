package ru.kiasystems.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table (name="products")
@NamedQuery(name="Product.getAllProducts", query = "SELECT p FROM Product p")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Long id;
    @Size(max = 999, min = 1)
    @Column(name="product_index")
    Integer index;
}
