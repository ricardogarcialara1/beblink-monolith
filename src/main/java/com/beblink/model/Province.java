package com.beblink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The type Province.
 */
@Data
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "province_id", unique = true, nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String name;
}
