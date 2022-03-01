package com.example.app.Objects;

public class Borrowing {
    private int bookId;
    private int customerId;
    public long id;
    public Customer user;
    public Book book;

    public int getBookId(){
        return this.bookId;
    }
    public int getCustomerId(){
        return this.customerId;
    }
}
