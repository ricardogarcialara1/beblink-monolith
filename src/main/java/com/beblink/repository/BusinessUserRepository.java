package com.beblink.repository;

import com.beblink.model.pk.BusinessUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.BusinessUser;
import java.util.Optional;

/**
 * The interface Business user repository.
 */
public interface BusinessUserRepository extends JpaRepository<BusinessUser, BusinessUserId> {
    /**
     * Find by business id and user id optional.
     *
     * @param businessId the business id
     * @param userId     the user id
     * @return the optional
     */
    Optional<BusinessUser> findByIdBusinessIdAndIdUserId(String businessId, String userId);
}
