package com.saho.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sahin.dagdelen on 2/19/2016.
 */

@Entity
@Table(name = "issued_books")
public class IssuedBook implements Serializable {

    @Id
    @Column(name = "book_id")
    int bookId;


    @Column(name = "reserving_user_id")
    long reservingUserId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public long getReservingUserId() {
        return reservingUserId;
    }

    public void setReservingUserId(long reservingUserId) {
        this.reservingUserId = reservingUserId;
    }


}
