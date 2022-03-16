package com.example.app.Services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Bookdata.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    private static BookDto mapToBookDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setAuthorFirstName(bookEntity.getAuthorFirstName());
        bookDto.setAuthorLastName(bookEntity.getAuthorLastName());
        bookDto.setIsbn(bookEntity.getIsbn());
        bookDto.setName(bookEntity.getName());
        bookDto.setBookCount(bookEntity.getBookCount());

        return bookDto;
    }

    @Transactional
    public Long createBook(BookDto bookDto){
        BookEntity be = new BookEntity();
        be.setAuthorFirstName(bookDto.getAuthorFirstName());
        be.setAuthorLastName(bookDto.getAuthorLastName());
        be.setIsbn(bookDto.getIsbn());
        be.setName(bookDto.getName());
        be.setBookCount(bookDto.getBookCount());
        this.bookRepository.save(be);
        return be.getId();
    }

    @Transactional
    public BookDto getBook(Long bookId) {
        Optional<BookEntity> byId = bookRepository.findById(bookId);
        if (byId.isPresent()) {
            return mapToBookDto(byId.get());
        }
        return null;
    }
    @Transactional
    public List<BookDto> getBooks(String bookAuthor) {
        List<BookDto> ret = new LinkedList<>();
        for (BookEntity b1 : bookRepository.findAll()) {
            BookDto b2 = mapToBookDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public void updateBook(int bookId, BookDto bookDto) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            byId.get().setAuthorFirstName(bookDto.getAuthorFirstName());
            byId.get().setAuthorLastName(bookDto.getAuthorLastName());
            byId.get().setIsbn(bookDto.getIsbn());
            byId.get().setName(bookDto.getName());
            byId.get().setBookCount(bookDto.getBookCount());
        }
    }

    @Transactional
    public void deleteBook(int bookId) {
        Optional<BookEntity> byId = bookRepository.findById((long)bookId);
        if (byId.isPresent()) {
            bookRepository.delete(byId.get());
        }
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


}
