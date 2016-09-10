package com.saho.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/20/2016.
 */
@Entity
@Table(name = "book_details")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private long borrowedUserId;

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "is_reserved")
    private boolean isReserved;


    @Column(name = "is_issued")
    private boolean isIssued;


    @Column(name = "borrower_user_id")
    private long borrowerUserId;


    @Column(name = "issued_by")
    private long issuedBy;


    @Column(name = "reserved_by")
    private long reservedBy;

    @Column(name = "issued_date")
    private Date issuedDate;

    @Column(name = "reserved_date")
    private Date reservedDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBorrowedUserId() {
        return borrowedUserId;
    }

    public void setBorrowedUserId(long borrowedUserId) {
        this.borrowedUserId = borrowedUserId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public long getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(long borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }

    public long getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(long issuedBy) {
        this.issuedBy = issuedBy;
    }

    public long getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(long reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }






}


