package com.example.app.Bookdata;

import com.example.app.Bookdata.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
  //  List<BookEntity> findAll();
}
