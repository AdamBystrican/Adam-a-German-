package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping("/api/books")
    public List<Book> get(){
//        List<Book> books = new ArrayList<Book>();
 //       books.add(new Book("Lord of the rings"));
  //      books.add(new Book("Harry Potter"));

        return books;
    }

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book){
        books.add(book);
        book.id = books.indexOf(book)+1;
        return book;
    }
    @GetMapping("/api/books/{bookId}")
    public Book get(@RequestParam Integer bookId){
        return books.get(bookId-1);
    }



}
