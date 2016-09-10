package com.saho.services;

import com.saho.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sahin.dagdelen on 1/22/2016.
 */
@Component
public interface BookService {

    List<Book> findAllBooksByCategory(String category);

    List<Book> findAllBooks();

    Book findByid(long id);

    void saveBook(Book book);

    void deleteBookById(long id);

    void updateBook(Book book);

    boolean isBookIdUnique(long id);

    List<Book> findAllBooksByName(String name);

}
