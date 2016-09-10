package com.saho.dao;

import com.saho.model.ReservedBook;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/24/2016.
 */

@Component
public interface ReservedBookDao {

    List<ReservedBook> findById(long userId);
    void saveBook(ReservedBook book);
    void deleteReservedBookById(long userId);
    List<ReservedBook> findAllRBooks();
}
