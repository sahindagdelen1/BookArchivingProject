package com.saho.model;


import org.apache.log4j.Logger;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */

@Entity
@Table(name = "library_users")
public class User {

    private static final Logger logger=Logger.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @NotEmpty
    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gsm_number")
    private String gsmNumber;



    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "registration_date", nullable = true)
    private String regDate;


    @NotEmpty
    @Column(name = "state", nullable = false)
    private String state = State.ACTIVE.getState();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_auth_map",
    joinColumns = { @JoinColumn(name = "user_id")  },  inverseJoinColumns = {@JoinColumn(name = "role_id")}   )
    private Set<AuthType> userProfiles=new HashSet<AuthType>();


    @Column(name = "email")
    private String email;




    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Set<AuthType> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<AuthType> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "User [id=" + userId + ", fullName=" + fullName + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", gsm=" + gsmNumber
                + ", email=" + email + ", Registration Date="+regDate +"]";
    }
}
