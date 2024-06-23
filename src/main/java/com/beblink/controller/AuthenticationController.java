package com.beblink.controller;

import com.beblink.model.security.AuthenticationRequest;
import com.beblink.model.security.AuthenticationResponse;
import com.beblink.service.impl.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping("/beblink")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Login response entity.
     *
     * @param authRequest the auth request
     * @return the response entity
     */
    @PreAuthorize("permitAll")
    /**
     * Login response entity.
     *
     * @param authRequest the auth request
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authRequest){
        var jwtDto = authenticationService.login(authRequest);

        return ResponseEntity.ok(jwtDto);
    }

}
