package com.socialnetwork.userservice.controller;

import com.socialnetwork.userservice.models.User;
import com.socialnetwork.userservice.schemas.UserCreate;
import com.socialnetwork.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public void addUser(@RequestBody UserCreate user){
        userService.addUser(user);
    }
    @RequestMapping("/{username}")
    public User userByName(@PathVariable String username){ return userService.getUserByName(username); }
}
