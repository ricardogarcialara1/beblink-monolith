package com.beblink.model;

import com.beblink.model.pk.BusinessUserId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type BusinessUser.
 */
@Data
@Entity
@Table(name = "business_user")
@AllArgsConstructor
public class BusinessUser {

    @EmbeddedId
    private BusinessUserId id;

    @Column(name = "business_role_id", nullable = false)
    private String businessRoleId;
}
