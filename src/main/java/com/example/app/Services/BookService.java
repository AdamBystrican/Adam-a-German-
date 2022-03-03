package com.example.app.Services;

import java.util.List;
import java.util.ArrayList;

import com.example.app.BookEntity;
import com.example.app.BookRepository;
import com.example.app.Objects.Book;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BookService {

    private BookRepository br;
    public BookService(BookRepository br){
        this.br = br;
    }
    /*
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
    }*/
    public Long createBook(@RequestBody Book book){
        BookEntity be = new BookEntity();
        be.setAuthorFirstName(book.getAuthorFirstName());
        be.setAuthorLastName(book.getAuthorLastName());
        be.setIsbn(book.getIsbn());
        be.setName(book.getName());
        be.setBookCount(book.getBookCount());
        br.save(be);
        return be.getId();
    }

}
