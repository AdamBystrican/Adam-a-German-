package com.example.app.Objects;

public class Borrowing {
    private long bookId;
    private int customerId;
    public long id;
    public Customer user;
    public Book book;

    public long getBookId(){
        return this.bookId;
    }
    public int getCustomerId(){
        return this.customerId;
    }
}
