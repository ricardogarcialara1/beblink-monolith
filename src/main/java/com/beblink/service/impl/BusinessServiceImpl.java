package com.beblink.service.impl;

import com.beblink.model.Business;
import com.beblink.model.Product;
import com.beblink.repository.BusinessRepository;
import com.beblink.repository.ProductRepository;
import com.beblink.service.BusinessService;
import com.beblink.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


/**
 * The type Product service.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;


    @Override
    public Business createBusiness(Business business){
        return businessRepository.save(product);
    }


    @Override
    public Business getBusinessById(Long id){
        Optional<Product> optionalProduct = businessRepository.findById(id);
        return optionalProduct.get();
    }


    @Override
    public ResponseEntity<List<Business>> getAllBusiness(Double latitude, Double longitude){

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
    public void deleteBusiness(Long id){
        businessRepository.deleteById(id);
    }
}
