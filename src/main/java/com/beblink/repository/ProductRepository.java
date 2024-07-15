package com.beblink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.Product;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
