package com.socialnetwork.userservice.models;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class User {
    @Id
    private int id;
    private String username;
    private String email;
    private  String password;
}
