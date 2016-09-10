package com.saho.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sahin.dagdelen on 1/22/2016.
 */

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;


    @Size(min = 3,max = 50)
    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "CATEGORY", nullable = false)
    private String category;


    @NotNull
    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    @Column(name = "ADDEDDATE",nullable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
     private DateTime addedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public DateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(DateTime addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "[id : "+id+", name "+name+", isbn "+isbn+", category "+category+" ]";
    }
}
