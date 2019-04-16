package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Wallet;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return this.customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer c) {
        return this.customerService.saveCustomer(c);
    }

    @GetMapping("/{id}/sum")
    private BigDecimal getSum(@PathVariable Long id){
        return customerService.getSumPayments(id);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer c) {
        this.customerService.updateCustomer(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        this.customerService.deleteCustomerById(id);
    }

    @DeleteMapping
    public void deleteAllCustomers() {
        this.customerService.deleteAllCustomers();
    }
}
