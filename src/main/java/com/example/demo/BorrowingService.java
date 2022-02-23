package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {
    BookService bookService;
    CustomerService customerService;

    public BorrowingService(BookService bookService, CustomerService customerService) {
        this.bookService = bookService;
        this.customerService = customerService;
    }

    private final List<Borrowing> borrowings= new ArrayList<>();

    public Borrowing getBorrowingsbyId(@PathVariable Integer borrowingId){
        Borrowing borrowing = new Borrowing();
        Book book = bookService.getBookById(borrowing.getBookId());
        Customer customer = customerService.getCustomersById(borrowing.getCustomerId());
        return borrowing;
    }
    public List<Borrowing> getBorrowings(){
        return borrowings;
    }


    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        borrowing.book = bookService.getBookById(borrowing.getBookId());
        borrowing.user = customerService.getCustomersById(borrowing.getCustomerId());
        borrowings.add(borrowing);
        borrowing.id = borrowings.indexOf(borrowing) + 1;
        return borrowing;
    }
    public void deleteBorrowing(@RequestParam Integer borrowingId){
        borrowings.remove(borrowingId-1);
    }

}
