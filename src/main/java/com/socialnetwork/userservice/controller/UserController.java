package com.socialnetwork.userservice.controller;

import com.socialnetwork.userservice.models.User;
import com.socialnetwork.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
