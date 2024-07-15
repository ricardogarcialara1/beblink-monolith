package com.beblink.service.impl;

import com.beblink.model.Product;
import com.beblink.repository.ProductRepository;
import com.beblink.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The type Product service.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }


    @Override
    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }


    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
