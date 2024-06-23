package com.beblink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The type BusinessTable.
 */
@Data
@Entity
@Table(name = "business_table")
public class BusinessTable {

    @Id
    @Column(name = "business_table_id", unique = true, nullable = false)
    private String businessTableId;

    @Column(name = "business_id", nullable = false)
    private String businessId;

    @Column(nullable = false)
    private Integer number;
}
