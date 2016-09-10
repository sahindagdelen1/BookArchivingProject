package com.saho.services;

import com.saho.dao.UserDao;
import com.saho.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    private static final Logger logger=Logger.getLogger(BookServiceImpl.class);


    public List<User> listAllUsers() {
       return   userDao.listAllUsers();
    }

    public void updateUser(User user) {
            User entityUser=userDao.getUserById(user.getUserId());
        if(entityUser!=null){
            entityUser.setAddress(user.getAddress());
            entityUser.setFullName(user.getFullName());
            entityUser.setGsmNumber(user.getGsmNumber());
            entityUser.setPhoneNumber(user.getPhoneNumber());
            entityUser.setState(user.getState());
            entityUser.setUserProfiles(user.getUserProfiles());
            entityUser.setUserId(user.getUserId());
            entityUser.setRegDate(user.getRegDate());
            entityUser.setEmail(user.getEmail());
         }
     }

    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public void deleteUser(User user) {
         userDao.deleteUser(user);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
