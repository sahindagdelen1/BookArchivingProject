package com.saho.dao;

import com.saho.model.ReservedBook;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/24/2016.
 */

@Repository("reservedBookDao")
public class ReservedBookDaoImpl extends AbstractDao<Long,ReservedBook> implements  ReservedBookDao {
    public List<ReservedBook> findById(long userId) {
        Criteria criteria=createEntityCriteria();
        criteria.add(Restrictions.eq("borrowerUserID",userId));
        return (List<ReservedBook>)criteria.list();
    }

    public void saveBook(ReservedBook book) {
        persist(book);
    }

    public void deleteReservedBookById(long userId) {
        Query query=getSession().createSQLQuery("delete from reserved_book where borrower_user_id=:userid");
        query.setLong("userid",userId);
        query.executeUpdate();
    }

    public List<ReservedBook> findAllRBooks() {
        Criteria criteria=createEntityCriteria();
        return (List<ReservedBook>)criteria.list();
    }
}
