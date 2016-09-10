package com.saho.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sahin.dagdelen on 2/c21/2016.
 */

@Entity
@Table(name = "reserved_book")
@Component
public class ReservedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "book_id",nullable = false)
    private long bookId;

    @Column(name = "borrower_user_id")
    private long borrowerUserID;

    @Column(name = "insert_date")
    private Date insertDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBorrowerUserID() {
        return borrowerUserID;
    }

    public void setBorrowerUserID(long borrowerUserID) {
        this.borrowerUserID = borrowerUserID;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }



}
