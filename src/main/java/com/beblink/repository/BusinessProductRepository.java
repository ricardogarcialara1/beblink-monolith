package com.beblink.repository;

import com.beblink.model.BusinessProduct;
import com.beblink.model.pk.BusinessProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface User repository.
 */
@Repository
public interface BusinessProductRepository extends JpaRepository<BusinessProduct, BusinessProductId> {

}
