package com.saho.dao;

import com.saho.model.AuthType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/17/2016.
 */

@Repository("authTypeDao")
public class AuthTypeDaoImpl extends AbstractDao<Long,AuthType> implements AuthTypeDao {

    @SuppressWarnings("unchecked")
    public List<AuthType> findAll() {
        Criteria criteria=createEntityCriteria();
        criteria.addOrder(Order.asc("type"));
        return criteria.list();
    }

    public AuthType findByType(String type) {
        Criteria criteria=createEntityCriteria();
        criteria.add(Restrictions.eq("type",type));
        return (AuthType)criteria.uniqueResult();
    }

    public AuthType findById(Long id) {
        return   getByKey(id);
    }
}
