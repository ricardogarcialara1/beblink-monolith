package com.beblink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.BusinessRole;

import java.util.List;
import java.util.Optional;

/**
 * The interface Business role repository.
 */
public interface BusinessRoleRepository extends JpaRepository<BusinessRole, String> {
    /**
     * Find by business id list.
     *
     * @param businessId the business id
     * @return the list
     */
    List<BusinessRole> findByBusinessId(String businessId);

    /**
     * Find by business id and role id optional.
     *
     * @param businessId the business id
     * @param roleId     the role id
     * @return the optional
     */
    Optional<BusinessRole> findByBusinessIdAndBusinessRoleId(String businessId, String roleId);
}
