package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    // BOOK-------------------------------------------
    private final List<Book> books = new ArrayList<>();

    @GetMapping("/api/books")
    public List<Book> getBooks(){
//        List<Book> books = new ArrayList<Book>();
 //       books.add(new Book("Lord of the rings"));
  //      books.add(new Book("Harry Potter"));

        return books;
    }

    @DeleteMapping("/api/books/{bookId}")
        public void deleteBook(@RequestParam Integer bookId){
            books.remove(bookId-1);
    }
    @PutMapping("/api/books/{bookId}")
        public Book update(@RequestParam Integer bookId, @RequestBody Book book){
        book.id = bookId;
        books.set(bookId-1,book);
        return book;
    }


    @PostMapping("/api/books")
    public Book createBook(@RequestBody Book book){
        books.add(book);
        book.id = books.indexOf(book)+1;
        return book;
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBookById(@RequestParam Integer bookId){
        return books.get(bookId-1);
    }
    // BOOK-------------------------------------------

    // BORROWING-------------------------------------------
    private final List<Borrowing> borrowings= new ArrayList<>();

    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowings(){
        return borrowings;
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public Borrowing getBorrowingById(@RequestParam Integer borrowingId){
        return borrowings.get(borrowingId-1);
    }

    @PostMapping("/api/borrowings")
    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        borrowings.add(borrowing);
        borrowing.id = borrowings.indexOf(borrowing) + 1;
        return borrowing;
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@RequestParam Integer borrowingId){
        borrowings.remove(borrowingId-1);
    }
    // BORROWING-------------------------------------------


}
