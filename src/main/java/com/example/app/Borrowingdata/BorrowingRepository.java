package com.example.app.Borrowingdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends CrudRepository<BorrowingEntity, Long> {
}
