package com.userservice.userservice.services.implementation;

import com.userservice.userservice.entity.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String UserId) {
        return userRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("So Sorry but we don't get the user in the db" + UserId)
        );
    }

    @Override
    public User deleteUserById(String UserId) {
         User user = getUserById(UserId);
         userRepository.deleteById(UserId);
         return user;
    }

    @Override
    public List<User> getAllByUser() {
        return userRepository.findAll();
    }
}
