package com.saho.dao;

import com.saho.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao {
    public List<User> listAllUsers() {
        Criteria criteria=createEntityCriteria().addOrder(Order.asc("fullName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<User>) criteria.list();
    }


    public User getUserById(long userId) {
         User user= getByKey(userId);
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }

        return  user;
    }

    public void deleteUser(User user) {
        delete(user);
    }

    public void saveUser(User user) {
        user.setRegDate(new Timestamp(new Date().getTime()).toString());
        persist(user);
    }


}
