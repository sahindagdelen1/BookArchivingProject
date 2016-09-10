package com.saho.services;

import com.saho.dao.BookDao;
import com.saho.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sahin.dagdelen on 1/24/2016.
 */


@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao dao;


    public List<Book> findAllBooksByCategory(String category) {
        return dao.findAllBooksByCategory(category);
    }

    public Book findByid(long id) {
        return dao.findById(id);
    }

    public void saveBook(Book book) {
        dao.saveBook(book);
    }

    public void deleteBookById(long id) {
        dao.deleteBookById(id);
    }

    public List<Book> findAllBooks() {
        return dao.findAllBooks();
    }

    public void updateBook(Book book) {
        Book entity = dao.findById(book.getId());
        if (entity != null) {
            entity.setName(book.getName());
            entity.setCategory(book.getCategory());
            entity.setIsbn(book.getIsbn());
            entity.setAddedDate(book.getAddedDate());

        }


    }

    public boolean isBookIdUnique(long id) {
        Book book=findByid(id);
        return (book==null);
    }


    public List<Book> findAllBooksByName(String name) {
        return dao.findAllBooksByName(name);
    }
}
