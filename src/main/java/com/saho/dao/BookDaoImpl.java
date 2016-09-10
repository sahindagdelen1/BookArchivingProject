package com.saho.dao;

import com.saho.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * Created by sahin.dagdelen on 1/24/2016.
 */

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Integer,Book> implements  BookDao {

    public Book findById(long id) {
        return getByKey(id);
    }

    public void saveBook(Book book) {
         persist(book);
    }

    public void deleteBookById(long id) {
        Query query=getSession().createSQLQuery("delete from book where id=:id");
        query.setLong("id",id);
        query.executeUpdate();
    }

    public List<Book> findAllBooksByCategory(String category) {
        Criteria criteria=createEntityCriteria();
        criteria.add(Restrictions.ilike("category",category, MatchMode.ANYWHERE));
        return  (List<Book>) criteria.list();
    }


    public  List<Book> findAllBooks(){
        Criteria criteria=createEntityCriteria();
        return  (List<Book>) criteria.list();
    }

    public List<Book> findAllBooksByName(String nameP) {
        Criteria criteria=createEntityCriteria();
        criteria.add(Restrictions.ilike("name",nameP, MatchMode.ANYWHERE));
        return  (List<Book>)criteria.list();
    }
}
