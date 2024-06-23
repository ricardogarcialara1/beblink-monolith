package com.beblink.controller;

import com.beblink.model.User;
import com.beblink.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("beblink/v0/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    @PreAuthorize("hasAuthority('READ_ALL_PRODUCTS')")
    @GetMapping
    public List<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    /**
     * Search user by id user.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping("{id}")
    public User searchUserById(@PathVariable (value = "id", required = true) String id){
        return userServiceImpl.getUserById(id);
    }

    /**
     * Delete user by id.
     *
     * @param id the id
     */
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable (value = "id", required = true) String id){
        userServiceImpl.deleteUser(id);
    }
}
