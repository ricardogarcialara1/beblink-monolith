package com.beblink.controller.business;

import com.beblink.repository.BusinessRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beblink.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Business role controller.
 */
@RestController
@RequestMapping("beblink/v0/business")
public class BusinessRoleController {

    @Autowired
    private BusinessRoleRepository businessRoleRepository;

    /**
     * Gets roles.
     *
     * @param businessId the business id
     * @return the roles
     */
    @GetMapping("/{businessId}/roles")
    public ResponseEntity<Object> getRoles(@PathVariable Long businessId) {
        var roles = businessRoleRepository.findByBusinessId(businessId);
        return ResponseEntity.ok(roles);
    }

    /**
     * Gets one role.
     *
     * @param businessId the business id
     * @param roleId     the role id
     * @return the one role
     */
    @GetMapping("/{businessId}/roles/{roleId}")
    public ResponseEntity<BusinessRole> getOneRole(@PathVariable Long businessId, @PathVariable Long roleId) {
        var role = businessRoleRepository.findByBusinessIdAndId(businessId, roleId);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Save role response entity.
     *
     * @param businessId the business id
     * @param role       the role
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @PostMapping("/{businessId}/roles")
    public ResponseEntity<Object> saveRole(@PathVariable Long businessId, @RequestBody BusinessRole role) {
        role.setBusinessId(businessId);
        var savedRole = businessRoleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    /**
     * Delete role response entity.
     *
     * @param businessId the business id
     * @param roleId     the role id
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @DeleteMapping("/{businessId}/roles/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long businessId, @PathVariable Long roleId) {
        var role = businessRoleRepository.findByBusinessIdAndId(businessId, roleId);
        if (role.isPresent()) {
            businessRoleRepository.delete(role.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
