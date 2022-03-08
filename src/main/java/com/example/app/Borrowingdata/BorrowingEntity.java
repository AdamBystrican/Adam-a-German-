package com.example.app.Borrowingdata;

import com.example.app.Objects.Book;
import com.example.app.Objects.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private Long id;
    private long bookId;
    private int customerId;
    private Customer user;
    private Book book;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public long getBookId() {
        return bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Customer getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
