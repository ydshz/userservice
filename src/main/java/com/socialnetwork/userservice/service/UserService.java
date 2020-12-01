package com.socialnetwork.userservice.service;

import com.socialnetwork.userservice.models.User;
import com.socialnetwork.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User>users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public void addUser(User user){
        userRepository.save(user);
    }
}
