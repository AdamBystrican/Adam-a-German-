package com.example.app.Borrowingdata;

import com.example.app.Bookdata.BookEntity;
import com.example.app.Customerdata.CustomerEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BorrowingEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CustomerEntity borrower;

    @ManyToOne
    private BookEntity book;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBorrower(CustomerEntity borrower) {
        this.borrower = borrower;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public CustomerEntity getBorrower() {
        return borrower;
    }

    public BookEntity getBook() {
        return book;
    }
}
