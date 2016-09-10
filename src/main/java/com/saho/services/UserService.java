package com.saho.services;

import com.saho.model.User;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */


public interface UserService {

    List<User> listAllUsers();
     void updateUser(User user);
    User getUserById(long userId);
    void  deleteUser(User user);
    void saveUser(User user);

}
