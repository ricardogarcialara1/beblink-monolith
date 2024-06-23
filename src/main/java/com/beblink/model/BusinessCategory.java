package com.beblink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * The type BusinessCategory.
 */
@Data
@Entity
@Table(name = "business_category")
public class BusinessCategory {

    @Id
    @Column(name = "business_category_id", unique = true, nullable = false)
    private String businessCategoryId;

    @Column(nullable = false)
    private String name;
}
