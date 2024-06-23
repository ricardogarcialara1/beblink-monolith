package com.beblink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The type Product.
 */
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id", unique = true, nullable = false)
    private String productId;

    @Column(nullable = false)
    private String name;

    private String image;

    @Column(name = "business_id", nullable = false)
    private String businessId;
}
