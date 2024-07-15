package com.beblink.service;

import com.beblink.model.Business;
import org.springframework.http.ResponseEntity;

import java.util.List;


/**
 * The interface Business service.
 */
public interface BusinessService {


    /**
     * Create business business.
     *
     * @param business the business
     * @return the business
     */
    public Business createBusiness(Business business);

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    public Business getBusinessById(Long id);

    /**
     * Gets all products.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the all products
     */
    public ResponseEntity<List<Business>> getAllBusiness(Double latitude, Double longitude);

    /**
     * Delete product.
     *
     * @param id the id
     */
    public void deleteBusiness(Long id);
}
