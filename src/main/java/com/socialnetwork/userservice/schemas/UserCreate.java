package com.socialnetwork.userservice.schemas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreate {
    private String username;
    private String email;
    private  String password;
}
