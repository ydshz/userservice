package com.socialnetwork.userservice.repository;

import com.socialnetwork.userservice.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT user FROM User user WHERE user.username=?1")
    public User getByUsername(String username);
}
