package com.socialnetwork.userservice.schemas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVerify {
    private String username;
    private  String password;
}
