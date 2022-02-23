package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    private BorrowingService borrowingSerivce;

    public BorrowingController(BorrowingService borrowingSerivce) {
        this.borrowingSerivce = borrowingSerivce;
    }

    // BORROWING-------------------------------------------


    @GetMapping
    public List<Borrowing> get(){
        return borrowingSerivce.getBorrowings();
    }

    @GetMapping("/{borrowingId}")
    public Borrowing getById(@RequestParam Integer borrowingId){
        return borrowingSerivce.getBorrowingbyId(borrowingId);
    }

    @PostMapping
    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        borrowingSerivce.createBorrowing(borrowing);
        return borrowing;
    }

    @DeleteMapping("/{borrowingId}")
    public void deleteBorrowing(@RequestParam Integer borrowingId){
        borrowingSerivce.deleteBorrowing(borrowingId);
    }
    // BORROWING-------------------------------------------
}
