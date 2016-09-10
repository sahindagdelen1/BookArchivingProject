package com.saho.dao;

import com.saho.model.AuthType;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/17/2016.
 */
public interface AuthTypeDao {

    List<AuthType> findAll();

    AuthType findByType(String type);


    AuthType findById(Long id);
}
