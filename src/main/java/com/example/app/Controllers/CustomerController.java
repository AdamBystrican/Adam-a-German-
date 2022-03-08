package com.example.app.Controllers;

import com.example.app.Customerdata.CustomerDto;
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
    public List<CustomerDto> getCustomers(@RequestParam(required = false) String customer){
        return customerService.getCustomers(customer);
    }
    @PostMapping
    public Long createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable Long customerId ){
        return customerService.getCustomer(customerId);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
    }
    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }
    //Customers----------------------------------------
}
