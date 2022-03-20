package com.example.app.Borrowingdata;

import com.example.app.Bookdata.BookEntity;
import com.example.app.Customerdata.CustomerEntity;

public class BorrowingDto {
    private CustomerEntity borrower;
    private BookEntity book;

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public void setBorrower(CustomerEntity borrower) {
        this.borrower = borrower;
    }

    public CustomerEntity getBorrower() {
        return borrower;
    }

    public BookEntity getBook() {
        return book;
    }
}
