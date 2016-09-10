package com.saho.converter;

import com.saho.model.AuthType;
import com.saho.services.AuthTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

/**
 * Created by sahin.dagdelen on 2/17/2016.
 */

@Component
public class RoleToAuthTypeConverter implements Converter<Object,AuthType> {


    @Autowired
    AuthTypeService authTypeService;

    public AuthType convert(Object source) {
        Long id=Long.parseLong((String)source);
        AuthType authType=authTypeService.findById(id);
        System.out.println(authType);
        return authType;
     }
}
