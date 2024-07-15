package com.beblink.controller;

import com.beblink.model.Product;
import com.beblink.model.User;
import com.beblink.service.impl.ProductServiceImpl;
import com.beblink.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The type Product controller.
 */
@RestController
@RequestMapping("beblink/v0/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productServiceImpl.createProduct(product);
    }

    /**
     * Get all products list.
     *
     * @return the list
     */
    @GetMapping
    public List<Product> getAllProducts(){
        return productServiceImpl.getAllProducts();
    }


    /**
     * Search product by id product.
     *
     * @param id the id
     * @return the product
     */
    @GetMapping("{id}")
    public Product searchProductById(@PathVariable (value = "id", required = true) Long id){
        return productServiceImpl.getProductById(id);
    }

    /**
     * Delete product by id.
     *
     * @param id the id
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable (value = "id", required = true) Long id){
        productServiceImpl.deleteProduct(id);
    }
}
