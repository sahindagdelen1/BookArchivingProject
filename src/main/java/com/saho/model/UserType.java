package com.saho.model;

/**
 * Created by sahin.dagdelen on 2/14/2016.
 */
public enum UserType {

    ADMIN("ADMIN"),GUEST("GUEST"),MEMBER("MEMBER"),LIBRARIAN("LIBRARIAN");


    String userProfileType;


    private UserType(String userProfileType){
        this.userProfileType=userProfileType;
    }

    public String getUserProfileType(){
        return  userProfileType;
    }

}
