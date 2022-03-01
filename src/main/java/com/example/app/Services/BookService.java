package com.example.app.Services;

import java.util.List;
import java.util.ArrayList;

import com.example.app.Objects.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks(){
        return books;
    }

    public Book createBook(@RequestBody Book book){
        books.add(book);
        book.id = books.indexOf(book)+1;
        return book;
    }
    public Book getBookById(@RequestParam Integer bookId){
        return books.get(bookId-1);
    }

    public Book updateBook(@RequestParam Integer bookId, @RequestBody Book book){
        book.id = bookId;
        books.set(bookId-1,book);
        return book;
    }
    public void deleteBook(@RequestParam Integer bookId){books.remove(bookId-1);
    }

}
