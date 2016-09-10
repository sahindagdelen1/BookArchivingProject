package com.saho.services;

import com.saho.dao.AuthTypeDao;
import com.saho.model.AuthType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/17/2016.
 */
@Service("authTypeService")
@Transactional
public class AuthTypeServiceImpl implements AuthTypeService {


    @Autowired
    AuthTypeDao authTypeDao;

    public List<AuthType> findAll() {
        return authTypeDao.findAll();
    }

    public AuthType findByType(String type) {
        return authTypeDao.findByType(type);
    }

    public AuthType findById(Long id) {
        return authTypeDao.findById(id);
    }
}
