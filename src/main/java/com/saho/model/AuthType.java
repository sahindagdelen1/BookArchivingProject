package com.saho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */

@Entity
@Table(name = "authorization_type")
public class AuthType {



    @Id
    private Long id;

    @Column(name = "type" ,length = 30,unique = true,nullable = false)
    private String type=UserType.MEMBER.getUserProfileType();





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AuthType))
            return false;
        AuthType other = (AuthType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return type;
    }
}
