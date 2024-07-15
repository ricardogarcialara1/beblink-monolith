package com.beblink.controller.business;

import com.beblink.model.*;
import com.beblink.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * The type Business controller.
 */
@RestController
@RequestMapping("beblink/v0/business")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    /**
     * Gets list.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the list
     */
    @GetMapping
    public ResponseEntity<Object> getAllBusiness(@RequestParam(required = false) Double latitude, @RequestParam(required = false) Double longitude) {
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

    /**
     * Gets one.
     *
     * @param businessId the business id
     * @return the one
     */
    @GetMapping("/{businessId}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long businessId) {
        var business = businessRepository.findById(businessId);
        return business.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Save response entity.
     *
     * @param business the business
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @PostMapping
    public ResponseEntity<Object> createBusiness(@RequestBody Business business) {
        var savedBusiness = businessRepository.save(business);
        return ResponseEntity.ok(savedBusiness);
    }

    /**
     * Delete response entity.
     *
     * @param businessId the business id
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @DeleteMapping("/{businessId}")
    public ResponseEntity<Object> deleteBusiness(@PathVariable Long businessId) {
        if (!businessRepository.existsById(businessId)) {
            return ResponseEntity.notFound().build();
        }
        businessRepository.deleteById(businessId);
        return ResponseEntity.ok().build();
    }
    /*

    // Métodos para usuarios
    @GetMapping("/{businessId}/users")
    public ResponseEntity<Object> getUsers(@PathVariable Long businessId) {
        var business = businessUserRepository.findById(businessId);
        var users = userRepository.findByUsername(business.get().);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{businessId}/users/{userId}")
    public ResponseEntity<User> getOneUser(@PathVariable Long businessId, @PathVariable Long userId) {
        var user = userRepository.findUserByBusinessIdAndUserId(businessId, userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{businessId}/users")
    public ResponseEntity<Object> saveUser(@PathVariable Long businessId, @RequestBody User user) {
        userRepository.save(user);
        var businessUser = new BusinessUser(new BusinessUserId(businessId, user.getId()), user.getRole().toString());
        businessUserRepository.save(businessUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{businessId}/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long businessId, @PathVariable Long userId) {
        var businessUser = businessUserRepository.findByBusinessIdAndUserId(businessId, userId);
        if (businessUser.isPresent()) {
            businessUserRepository.delete(businessUser.get());
            userRepository.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Métodos para mesas
    @GetMapping("/{businessId}/tables")
    public ResponseEntity<Object> getTables(@PathVariable Long businessId) {
        var tables = businessTableRepository.findByBusinessId(businessId);
        return ResponseEntity.ok(tables);
    }

    @PostMapping("/{businessId}/tables")
    public ResponseEntity<Object> saveTable(@PathVariable Long businessId, @RequestBody BusinessTable table) {
        table.setBusinessId(businessId);
        var savedTable = businessTableRepository.save(table);
        return ResponseEntity.ok(savedTable);
    }

    @DeleteMapping("/{businessId}/tables/{tableId}")
    public ResponseEntity<Object> deleteTable(@PathVariable Long businessId, @PathVariable String tableId) {
        var table = businessTableRepository.findByBusinessIdAndTableId(businessId, tableId);
        if (table.isPresent()) {
            businessTableRepository.delete(table.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
