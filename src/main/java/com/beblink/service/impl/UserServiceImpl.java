package com.beblink.service.impl;

import com.beblink.model.User;
import com.beblink.repository.UserRepository;
import com.beblink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    /**
     * Get user by id user.
     *
     * @param id the id
     * @return the user
     */
    @Override
    public User getUserById(String id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Delete user.
     *
     * @param id the id
     */
    @Override
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
