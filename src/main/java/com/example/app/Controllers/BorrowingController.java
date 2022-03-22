package com.example.app.Controllers;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Borrowingdata.BorrowingDto;
import com.example.app.Services.BorrowingService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<BorrowingDto> getBorrowings(){
        return borrowingService.getBorrowings();
    }
    @DeleteMapping("/{borrowingId}")
    public void delete(@PathVariable int borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }

    @PostMapping
    public Long create(@RequestBody BorrowingDto borrowingDto){
        return borrowingService.createBorrowing(borrowingDto);
    }
    @GetMapping("/{borrowingId}")
    public BorrowingDto getBorrowing(@PathVariable Long borrowingId){
        return borrowingService.getBorrowing(borrowingId);
    }
}
