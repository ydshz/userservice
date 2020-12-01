package com.socialnetwork.userservice.repository;

import com.socialnetwork.userservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
