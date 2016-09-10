package com.saho.dao;

import com.saho.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */

@Component
public interface UserDao {

    List<User> listAllUsers();
    User getUserById(long userId);
    void  deleteUser(User user);
    void saveUser(User user);
}
