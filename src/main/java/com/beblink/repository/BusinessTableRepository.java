package com.beblink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.BusinessTable;

import java.util.List;
import java.util.Optional;

/**
 * The interface Business table repository.
 */
public interface BusinessTableRepository extends JpaRepository<BusinessTable, String> {
    /**
     * Find by business id list.
     *
     * @param businessId the business id
     * @return the list
     */
    List<BusinessTable> findByBusinessId(String businessId);

    /**
     * Find by business id and table id optional.
     *
     * @param businessId the business id
     * @param tableId    the table id
     * @return the optional
     */
    Optional<BusinessTable> findByBusinessIdAndBusinessTableId(String businessId, String tableId);
}
