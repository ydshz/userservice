package com.socialnetwork.userservice.service;

import com.socialnetwork.userservice.exceptions.NonexistingUserException;
import com.socialnetwork.userservice.models.User;
import com.socialnetwork.userservice.repository.UserRepository;
import com.socialnetwork.userservice.schemas.UserCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void addUser(UserCreate userCreate){
        User user = new User();
        user.setUsername(userCreate.getUsername());
        user.setEmail(userCreate.getEmail());
        user.setPassword(userCreate.getPassword());
        userRepository.save(user);
    }
    public User getUserByName(String username) throws NonexistingUserException{
        User current_user = userRepository.getByUsername(username);
        if(current_user == null){
            throw new NonexistingUserException("The user " + username + " doesnt exist.");
        }
        else {
            return current_user;
        }
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
    public boolean verifyPassword(String username, String password){
        try{
            User user = getUserByName(username);
            return user.getPassword().equals(password);
        } catch (NonexistingUserException nonexistingUserException) {
            return false;
        }
    }
}
