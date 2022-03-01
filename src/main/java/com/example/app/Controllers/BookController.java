package com.example.app.Controllers;

import com.example.app.Objects.Book;
import com.example.app.Services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // BOOK-------------------------------------------


    @GetMapping
    public List<Book> get(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{bookId}")
    public void delete(@RequestParam Integer bookId){
        bookService.deleteBook(bookId);
    }
    @PutMapping("/{bookId}")
    public Book update(@RequestParam Integer bookId, @RequestBody Book book){
        bookService.updateBook(bookId,book);
        return book;
    }


    @PostMapping
    public Book create(@RequestBody Book book){
        bookService.createBook(book);
        return book;
    }
    @GetMapping("/{bookId}")
    public Book getById(@RequestParam Integer bookId){
        return bookService.getBookById(bookId);
    }
    // BOOK-------------------------------------------
}
