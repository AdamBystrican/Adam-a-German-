package com.example.app.Services;

import com.example.app.Objects.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    public List<Customer> getCustomers(){
        return customers;
    }
    public List<Customer> createCustomers(@RequestBody Customer customer){
        customers.add(customer);
        customer.id = customers.indexOf(customer)+1;
        return customers;
    }

    public Customer getCustomersById(@RequestParam Integer customerId ){
        return customers.get(customerId-1);
    }
    public void deleteCustomers(@RequestParam Integer customerId){
        customers.remove(customerId-1);
    }
    public Customer updateCustomers(@RequestParam Integer customerId, @RequestBody Customer customer){
        customer.id = customerId;
        customers.set(customerId-1,customer);
        return customer;
    }
}
