package com.saho.converter;

import com.saho.model.User;
import com.saho.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by sahin.dagdelen on 2/24/2016.
 */

@Component
public class UserIdToUserConverter implements  Converter<String,User> {

    @Autowired
    UserService userService;

    private static final Logger logger=Logger.getLogger(UserIdToUserConverter.class);

    public User convert(String source) {
        logger.debug("    ---->  UserIdToUserConverter  convert  "+source);
        Long userId=Long.valueOf(source);
         return userService.getUserById(userId);
    }
}
