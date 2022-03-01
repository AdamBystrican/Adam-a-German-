package com.example.app.Controllers;

import com.example.app.Objects.Customer;
import com.example.app.Services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    //Customers----------------------------------------

    @GetMapping
    public List<Customer> get(){
        return customerService.getCustomers();
    }
    @PostMapping
    public Customer createCustomers(@RequestBody Customer customer){
        customerService.createCustomers(customer);
        return customer;
    }

    @GetMapping("/{customerId}")
    public Customer getById(@RequestParam Integer customerId ){
        return customerService.getCustomersById(customerId);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomers(@RequestParam Integer customerId){
        customerService.deleteCustomers(customerId);
    }
    @PutMapping("/{customerId}")
    public Customer updateCustomers(@RequestParam Integer customerId, @RequestBody Customer customer){
        customerService.updateCustomers(customerId, customer);
        return customer;
    }
    //Customers----------------------------------------
}
