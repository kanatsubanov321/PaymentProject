package com.example.demo.service;

import com.example.demo.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer c);

    void updateCustomer(Customer c);

    void deleteCustomerById(Long id);

    void deleteAllCustomers();

    Customer changeActiveStatus(Customer c);
    BigDecimal getSumPayments(Long id);
}
