package com.example.app.Services;

import com.example.app.Bookdata.BookDto;
import com.example.app.Bookdata.BookEntity;
import com.example.app.Customerdata.CustomerDto;
import com.example.app.Customerdata.CustomerEntity;
import com.example.app.Customerdata.CustomerRepository;
import com.example.app.Objects.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    private static CustomerDto mapToCustomerDto(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setContact(customerEntity.getContact());
        return customerDto;
    }
    @Transactional
    public Long createCustomer(CustomerDto customerDto){
        CustomerEntity ce = new CustomerEntity();
        ce.setFirstName(customerDto.getFirstName());
        ce.setLastName(customerDto.getLastName());
        ce.setContact(customerDto.getContact());
        this.customerRepository.save(ce);
        return ce.getId();
    }
    @Transactional
    public CustomerDto getCustomer(Long customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {
            return mapToCustomerDto(byId.get());
        }
        return null;
    }

    @Transactional
    public List<CustomerDto> getCustomers(String customer) {
        List<CustomerDto> ret = new LinkedList<>();
        for (CustomerEntity c1 : customerRepository.findAll()) {
            CustomerDto c2 = mapToCustomerDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public void updateCustomer(int customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()) {
            byId.get().setFirstName(customerDto.getFirstName());
            byId.get().setLastName(customerDto.getContact());
            byId.get().setContact(customerDto.getContact());
        }
    }

    @Transactional
    public void deleteCustomer(int customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()) {
            customerRepository.delete(byId.get());
        }
    }

    /*
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
    }*/
}
