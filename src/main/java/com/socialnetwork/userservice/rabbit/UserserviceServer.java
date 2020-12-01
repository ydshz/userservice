package com.socialnetwork.userservice.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnetwork.userservice.schemas.UserVerify;
import com.socialnetwork.userservice.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class UserserviceServer {
    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @RabbitListener(queues = "socialmedia.rpc.requests")
    public boolean verifyPassword(String request) throws JsonProcessingException {
        UserVerify userVerify = mapper.readValue(request, UserVerify.class);
        return userService.verifyPassword(userVerify.getUsername(), userVerify.getPassword());
    }
}
