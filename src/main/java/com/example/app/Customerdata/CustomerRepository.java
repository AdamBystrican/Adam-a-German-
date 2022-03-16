package com.example.app.Customerdata;

import com.example.app.Objects.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
   // List<CustomerEntity> findAll();
}
