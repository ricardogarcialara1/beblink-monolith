package com.beblink.service;

import com.beblink.model.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    public User createUser(User user);

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    public User getUserById(String id);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers();

    /**
     * Delete user.
     *
     * @param id the id
     */
    public void deleteUser(String id);
}
