package com.saho.converter;

import com.saho.model.Book;
import com.saho.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by sahin.dagdelen on 2/21/2016.
 */
@Component
public class BookIdtoBookConverter implements Converter<Object,Book> {


    @Autowired
    BookService bookService;

    public Book convert(Object source) {
         Long id=Long.parseLong(source.toString());
          Book book=bookService.findByid(id);
            return book;
    }
}
