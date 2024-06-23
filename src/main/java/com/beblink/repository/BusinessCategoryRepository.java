package com.beblink.repository;

import com.beblink.model.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface User repository.
 */
@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, String> {

}
