package com.saho.services;

import com.saho.model.AuthType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/17/2016.
 */
@Component
public interface AuthTypeService {
    List<AuthType> findAll();

    AuthType findByType(String type);


    AuthType findById(Long id);
}
