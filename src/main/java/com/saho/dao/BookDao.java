package com.saho.dao;

import com.saho.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sahin.dagdelen on 1/24/2016.
 */
@Component
public interface BookDao {

    Book findById(long id);
    void saveBook(Book book);
    void deleteBookById(long id);
    List<Book> findAllBooksByCategory(String category);
    List<Book> findAllBooksByName(String name);
    List<Book> findAllBooks();

}
