package com.saho.model;

import java.util.List;

/**
 * Created by sahin.dagdelen on 2/22/2016.
 */
public class BookDetailsForm {


    public BookDetailsForm() {
    }

    private BookDetails bookDetails;
    private Book book;
     private User user;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
