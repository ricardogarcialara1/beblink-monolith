package com.beblink.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The type Business.
 */
@Data
@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double latitude;
    private Double longitude;
    private String address;

    @Column(name = "c_address")
    private String cAddress;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "province_id")
    private String provinceId;

    @Transient
    private Double distance;

}
