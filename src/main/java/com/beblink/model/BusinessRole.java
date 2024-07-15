package com.beblink.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The type BusinessRole.
 */
@Data
@Entity
@Table(name = "business_role")
public class BusinessRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_id", nullable = false)
    private Long businessId;

    @Column(nullable = false)
    private String name;
}
