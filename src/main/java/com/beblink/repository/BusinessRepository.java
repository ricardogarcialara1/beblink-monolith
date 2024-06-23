package com.beblink.repository;

import com.beblink.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface User repository.
 */
@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {

    /**
     * Find all by order by name list.
     *
     * @return the list
     */
    List<Business> findAllByOrderByName();

}
