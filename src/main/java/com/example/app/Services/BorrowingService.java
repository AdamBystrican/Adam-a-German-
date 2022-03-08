package com.example.app.Services;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Borrowingdata.BorrowingDto;
import com.example.app.Borrowingdata.BorrowingEntity;
import com.example.app.Borrowingdata.BorrowingRepository;
import com.example.app.Objects.Borrowing;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {
    BorrowingRepository borrowingRepository;
    BookService bookService;
    CustomerService customerService;

    public BorrowingService(BorrowingRepository borrowingRepository, BookService bookService, CustomerService customerService) {
        this.borrowingRepository = borrowingRepository;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    private static BorrowingDto mapToBorrowingDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setBookId(borrowingEntity.getBookId());
        borrowingDto.setCustomerId(borrowingEntity.getCustomerId());
        borrowingDto.setBook(borrowingEntity.getBook());
        borrowingDto.setUser(borrowingEntity.getUser());
        return borrowingDto;
    }

    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto){
        BorrowingEntity be = new BorrowingEntity();
        be.setBookId(borrowingDto.getBookId());
        be.setUser(borrowingDto.getUser());
        be.setCustomerId(borrowingDto.getCustomerId());
        this.borrowingRepository.save(be);
        return be.getId();
    }

    /*
    private final List<Borrowing> borrowings= new ArrayList<>();

    public Borrowing getBorrowingbyId(@PathVariable Integer borrowingId){
        return borrowings.get(borrowingId-1);
    }
    public List<Borrowing> getBorrowings(){
        return borrowings;
    }


    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        borrowing.book = bookService.getBook(borrowing.getBookId());
        borrowing.user = customerService.getCustomersById(borrowing.getCustomerId());
        borrowings.add(borrowing);
        borrowing.id = borrowings.indexOf(borrowing) + 1;
        return borrowing;
    }
    public void deleteBorrowing(@RequestParam Integer borrowingId){
        borrowings.remove(borrowingId-1);
    }*/

}
