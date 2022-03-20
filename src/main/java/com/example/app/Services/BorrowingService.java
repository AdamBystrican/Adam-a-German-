package com.example.app.Services;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Borrowingdata.BorrowingDto;
import com.example.app.Borrowingdata.BorrowingEntity;
import com.example.app.Borrowingdata.BorrowingRepository;
import com.example.app.Objects.Borrowing;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {
    private BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    private static BorrowingDto mapToBorrowingDto(BorrowingEntity borrowingEntity) {
        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setBorrower(borrowingEntity.getBorrower());
        borrowingDto.setBook(borrowingEntity.getBook());

        return borrowingDto;
    }
    @Transactional
    public Long createBorrowing(BorrowingDto borrowingDto){
        BorrowingEntity be = new BorrowingEntity();
        be.setBorrower(borrowingDto.getBorrower());
        be.setBook(borrowingDto.getBook());
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
    public void updateBorrowing(int borrowingId, BorrowingDto borrowingDto) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById((long)borrowingId);
        if (byId.isPresent()) {
            byId.get().setBorrower(borrowingDto.getBorrower());
            byId.get().setBook(borrowingDto.getBook());
        }
    }

    @Transactional
    public void deleteBorrowing(int borrowingId) {
        Optional<BorrowingEntity> byId = borrowingRepository.findById((long)borrowingId);
        if (byId.isPresent()) {
            borrowingRepository.delete(byId.get());
        }
    }


}
