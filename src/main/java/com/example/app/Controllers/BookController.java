package com.example.app.Controllers;

import com.example.app.Bookdata.BookDto;
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
    public List<BookDto> getBooks(@RequestParam(required = false) String bookAutrhor){
        return bookService.getBooks(bookAutrhor);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }
    @PutMapping("/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody BookDto bookDto){
        bookService.updateBook(bookId,bookDto);
    }


    @PostMapping
    public Long create(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }
    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable Long bookId){
        return bookService.getBook(bookId);
    }
    // BOOK-------------------------------------------
}
