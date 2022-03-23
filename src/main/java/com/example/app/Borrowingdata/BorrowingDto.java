package com.example.app.Borrowingdata;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Customerdata.CustomerDto;
import com.example.app.Customerdata.CustomerEntity;

public class BorrowingDto {

    private Long bookId;
    private Long borrowerId;
    private String borrower;
    private String book;

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBoorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getBook() {
        return book;
    }
}
