package com.beblink.service;

import com.beblink.model.Product;

import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    public Product createProduct(Product product);

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    public Product getProductById(Long id);

    /**
     * Gets all products.
     *
     * @return the all products
     */
    public List<Product> getAllProducts();

    /**
     * Delete product.
     *
     * @param id the id
     */
    public void deleteProduct(Long id);
}
