package com.example.demo.controller;

import com.example.demo.model.Customer;
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
    public Customer getCustomerById(@PathVariable Long id,
                                    @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return null;
        }
        return this.customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer c) {
        return this.customerService.saveCustomer(c);
    }

    @GetMapping("/{id}/sum")
    private BigDecimal getSum(@PathVariable Long id,
                              @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return null;
        }
        return customerService.getSumPayments(id);
    }

    @GetMapping("/{id}/balance")
    private int getCustomerBalance(@PathVariable Long id,
                                   @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return 0;
        }
        return customerService.getCustomerBalance(id);
    }

    @GetMapping("/{id}/phone")
    private int getCustomerPhone(@PathVariable Long id,
                                 @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return 0;
        }
        return customerService.getCustomerPhone(id);
    }

    @GetMapping("/{id}/info")
    private List<Object[]> getCustomerInfo(@PathVariable Long id,
                                 @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return null;
        }
        return customerService.getCustomerInfo(id);
    }

    @GetMapping("/{id}/code")
    private int getCustomerConfirmationCode(@PathVariable Long id,
                                            @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return 0;
        }
        return customerService.getCustomerConfirmationCode(id);
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
