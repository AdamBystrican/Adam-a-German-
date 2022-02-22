package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    // BOOK-------------------------------------------
    private final List<Book> books = new ArrayList<>();

    @GetMapping("/api/books")
    public List<Book> get(){

        return books;
    }

    @DeleteMapping("/api/books/{bookId}")
        public void delete(@RequestParam Integer bookId){
            books.remove(bookId-1);
    }
    @PutMapping("/api/books/{bookId}")
        public Book update(@RequestParam Integer bookId, @RequestBody Book book){
        book.id = bookId;
        books.set(bookId-1,book);
        return book;
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
    // BOOK-------------------------------------------

    //Customers----------------------------------------
    private final List<Customer> customers = new ArrayList<>();
    @GetMapping("/api/customers")
    public List<Customer> getCustomers(){

        return customers;
    }
    @PostMapping("/api/customers")
    public List<Customer> createCustomers(@RequestBody Customer customer){
        customers.add(customer);
        customer.id = customers.indexOf(customer)+1;
        return customers;
    }

     @GetMapping("/api/customers/{customerId}")
    public Customer getCustomers(@RequestParam Integer getId ){
        return customers.get(getId-1);

    }
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomers(@RequestParam Integer getId){
        books.remove(getId-1);
    }
    @PutMapping("/api/customers/{customerId}")
    public Customer updateCustomers(@RequestParam Integer customerId, @RequestBody Customer customer){
        customer.id = customerId;
        customers.set(customerId-1,customer);
        return customer;
    }
    //Customers----------------------------------------

}
