package com.beblink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends JpaRepository<Product, String> {
    /**
     * Find products by business id list.
     *
     * @param businessId the business id
     * @return the list
     */
    List<Product> findProductsByBusinessId(String businessId);

    /**
     * Find product by business id and product id optional.
     *
     * @param businessId the business id
     * @param productId  the product id
     * @return the optional
     */
    Optional<Product> findProductByBusinessIdAndProductId(String businessId, String productId);
}
