package com.beblink.model;

import com.beblink.model.pk.BusinessProductId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type BusinessProduct.
 */
@Data
@Entity
@Table(name = "business_product")
@AllArgsConstructor
public class BusinessProduct {

    @EmbeddedId
    private BusinessProductId id;

    @Column(nullable = false)
    private Double price;

}
