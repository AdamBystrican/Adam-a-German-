package com.example.app.Services;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Bookdata.BookRepository;
import com.example.app.Borrowingdata.BorrowingDto;
import com.example.app.Borrowingdata.BorrowingEntity;
import com.example.app.Borrowingdata.BorrowingRepository;
import com.example.app.Customerdata.CustomerEntity;
import com.example.app.Customerdata.CustomerRepository;
import com.example.app.Objects.Borrowing;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {
    private BorrowingRepository borrowingRepository;
    private CustomerRepository customerRepository;
    private BookRepository bookRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, CustomerRepository customerRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.borrowingRepository = borrowingRepository;
    }

    private static BorrowingDto mapToBorrowingDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setBorrower(borrowingEntity.getBorrower().getFirstName() + " " + borrowingEntity.getBorrower().getLastName());
        borrowingDto.setBook(borrowingEntity.getBook().getName());
        borrowingDto.setBookId(borrowingEntity.getBook().getId());
        borrowingDto.setBoorrowerId(borrowingEntity.getBorrower().getId());

        return borrowingDto;
    }
    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto){
        BorrowingEntity be = new BorrowingEntity();
        Optional<CustomerEntity> CbyId = customerRepository.findById(borrowingDto.getBorrowerId());
        if(CbyId.isPresent())
            be.setBorrower(CbyId.get());
        Optional<BookEntity> BbyId = bookRepository.findById(borrowingDto.getBookId());
        if(BbyId.isPresent())
            be.setBook(BbyId.get());
        this.borrowingRepository.save(be);
        return be.getId();
    }
    @Transactional
    public BorrowingDto getBorrowing(Long borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById(borrowingId);
        if (byId.isPresent()) {
            return mapToBorrowingDto(byId.get());
        }
        return null;
    }

    @Transactional
    public List<BorrowingDto> getBorrowings() {
        List<BorrowingDto> ret = new LinkedList<>();
        for (BorrowingEntity b1 : borrowingRepository.findAll()) {
            BorrowingDto b2 = mapToBorrowingDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public void deleteBorrowing(int borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById((long)borrowingId);
        if (byId.isPresent()) {
            borrowingRepository.delete(byId.get());
        }
    }


}
