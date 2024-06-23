package com.beblink.controller;

import com.beblink.model.*;
import com.beblink.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping
    public ResponseEntity<Object> getList(@RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude) {
        if (latitude != null && longitude != null) {
            var radioTierra = 6371; // Kilómetros
            var businessList = businessRepository.findAll();

            businessList.forEach(business -> {
                double lat = latitude;
                double lon = longitude;
                double distance = radioTierra * Math.acos(Math.cos(Math.toRadians(lat))
                        * Math.cos(Math.toRadians(business.getLatitude()))
                        * Math.cos(Math.toRadians(business.getLongitude()) - Math.toRadians(lon))
                        + Math.sin(Math.toRadians(lat))
                        * Math.sin(Math.toRadians(business.getLatitude())));
                business.setDistance(distance);
            });
            businessList.sort((b1, b2) -> Double.compare(b1.getDistance(), b2.getDistance()));

            return ResponseEntity.ok(businessList);
        }

        var businessList = businessRepository.findAllByOrderByName();
        return ResponseEntity.ok(businessList);
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<Business> getOne(@PathVariable String businessId) {
        var business = businessRepository.findById(businessId);
        return business.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Business business) {
        var savedBusiness = businessRepository.save(business);
        return ResponseEntity.ok(savedBusiness);
    }

    @DeleteMapping("/{businessId}")
    public ResponseEntity<Object> delete(@PathVariable String businessId) {
        if (!businessRepository.existsById(businessId)) {
            return ResponseEntity.notFound().build();
        }
        businessRepository.deleteById(businessId);
        return ResponseEntity.ok().build();
    }
    /*

    // Métodos para usuarios
    @GetMapping("/{businessId}/users")
    public ResponseEntity<Object> getUsers(@PathVariable String businessId) {
        var business = businessUserRepository.findById(businessId);
        var users = userRepository.findByUsername(business.get().);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{businessId}/users/{userId}")
    public ResponseEntity<User> getOneUser(@PathVariable String businessId, @PathVariable String userId) {
        var user = userRepository.findUserByBusinessIdAndUserId(businessId, userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{businessId}/users")
    public ResponseEntity<Object> saveUser(@PathVariable String businessId, @RequestBody User user) {
        userRepository.save(user);
        var businessUser = new BusinessUser(new BusinessUserId(businessId, user.getId()), user.getRole().toString());
        businessUserRepository.save(businessUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{businessId}/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable String businessId, @PathVariable String userId) {
        var businessUser = businessUserRepository.findByBusinessIdAndUserId(businessId, userId);
        if (businessUser.isPresent()) {
            businessUserRepository.delete(businessUser.get());
            userRepository.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Métodos para productos
    @GetMapping("/{businessId}/products")
    public ResponseEntity<Object> getProducts(@PathVariable String businessId) {
        var products = productRepository.findProductsByBusinessId(businessId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{businessId}/products/{productId}")
    public ResponseEntity<Product> getOneProduct(@PathVariable String businessId, @PathVariable String productId) {
        var product = productRepository.findProductByBusinessIdAndProductId(businessId, productId);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{businessId}/products")
    public ResponseEntity<Object> saveProduct(@PathVariable String businessId, @RequestParam double price, @RequestBody Product product) {
        productRepository.save(product);
        var businessProduct = new BusinessProduct(new BusinessProductId(businessId, product.getProductId()), price);
        businessProductRepository.save(businessProduct);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{businessId}/products/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String businessId, @PathVariable String productId) {
        var businessProduct = businessProductRepository.findById(new BusinessProductId(businessId, productId));
        if (businessProduct.isPresent()) {
            businessProductRepository.delete(businessProduct.get());
            productRepository.deleteById(productId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Métodos para mesas
    @GetMapping("/{businessId}/tables")
    public ResponseEntity<Object> getTables(@PathVariable String businessId) {
        var tables = businessTableRepository.findByBusinessId(businessId);
        return ResponseEntity.ok(tables);
    }

    @PostMapping("/{businessId}/tables")
    public ResponseEntity<Object> saveTable(@PathVariable String businessId, @RequestBody BusinessTable table) {
        table.setBusinessId(businessId);
        var savedTable = businessTableRepository.save(table);
        return ResponseEntity.ok(savedTable);
    }

    @DeleteMapping("/{businessId}/tables/{tableId}")
    public ResponseEntity<Object> deleteTable(@PathVariable String businessId, @PathVariable String tableId) {
        var table = businessTableRepository.findByBusinessIdAndTableId(businessId, tableId);
        if (table.isPresent()) {
            businessTableRepository.delete(table.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
