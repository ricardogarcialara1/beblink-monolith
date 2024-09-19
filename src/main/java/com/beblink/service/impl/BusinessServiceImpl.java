package com.beblink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beblink.model.Business;
import com.beblink.repository.BusinessRepository;
import com.beblink.service.BusinessService;

/**
 * The type Product service.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<List<Business>> getAllBusiness(Double latitude, Double longitude) {

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

    @Override
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
