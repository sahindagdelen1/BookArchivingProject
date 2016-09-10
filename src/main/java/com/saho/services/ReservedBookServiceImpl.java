package com.saho.services;

import com.saho.dao.ReservedBookDao;
import com.saho.model.ReservedBook;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/24/2016.
 */
@Transactional
@Service("reservedBookService")
public class ReservedBookServiceImpl implements  ReservedBookService {

    private static final Logger logger=Logger.getLogger(ReservedBookServiceImpl.class);


    @Autowired
    ReservedBookDao reservedBookDao;

    public List<ReservedBook> findById(long userId) {
        List<ReservedBook> list=reservedBookDao.findById(userId);
        logger.debug("user id "+userId+"  list size  "+list.size());
        return reservedBookDao.findById(userId);
    }

    public void saveBook(ReservedBook book) {
        reservedBookDao.saveBook(book);
    }

    public void deleteReservedBookById(long userId) {
        reservedBookDao.deleteReservedBookById(userId);
    }

    public List<ReservedBook> findAllRBooks() {
        return reservedBookDao.findAllRBooks();
    }
}
