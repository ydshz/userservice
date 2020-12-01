package com.socialnetwork.userservice.service;

import com.socialnetwork.userservice.models.User;
import com.socialnetwork.userservice.repository.UserRepository;
import com.socialnetwork.userservice.schemas.UserCreate;
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
    public void addUser(UserCreate userCreate){
        User user = new User();
        user.setUsername(userCreate.getUsername());
        user.setEmail(userCreate.getEmail());
        user.setPassword(userCreate.getPassword());
        userRepository.save(user);
    }
    public User getUserByName(String username){
        return userRepository.getByUsername(username);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    public void updateUser(User user, UserCreate userCreate){
        user.setUsername(userCreate.getUsername());
        user.setEmail(userCreate.getEmail());
        user.setPassword(userCreate.getPassword());
        userRepository.save(user);
    }
}
