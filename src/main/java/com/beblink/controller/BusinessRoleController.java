package com.beblink.controller;

import com.beblink.repository.BusinessRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beblink.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessRoleController {

    @Autowired
    private BusinessRoleRepository businessRoleRepository;

    @GetMapping("/{businessId}/roles")
    public ResponseEntity<Object> getRoles(@PathVariable String businessId) {
        var roles = businessRoleRepository.findByBusinessId(businessId);
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{businessId}/roles/{roleId}")
    public ResponseEntity<BusinessRole> getOneRole(@PathVariable String businessId, @PathVariable String roleId) {
        var role = businessRoleRepository.findByBusinessIdAndBusinessRoleId(businessId, roleId);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{businessId}/roles")
    public ResponseEntity<Object> saveRole(@PathVariable String businessId, @RequestBody BusinessRole role) {
        role.setBusinessId(businessId);
        var savedRole = businessRoleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    @DeleteMapping("/{businessId}/roles/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable String businessId, @PathVariable String roleId) {
        var role = businessRoleRepository.findByBusinessIdAndBusinessRoleId(businessId, roleId);
        if (role.isPresent()) {
            businessRoleRepository.delete(role.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
