package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServicelmpl implements CustomerService {
    @Autowired
    private CustomerRepository c;


    @Override
    public List<Customer> findAllCustomers() {
        return c.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return c.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer c) {
        return this.c.save(c);
    }

    @Override
    public void updateCustomer(Customer c) {
        this.c.save(c);
    }

    @Override
    public void deleteCustomerById(Long id) {
        c.deleteById(id);
    }

    @Override
    public void deleteAllCustomers() {
        c.deleteAll();
    }

    @Override
    public Customer changeActiveStatus(Customer c) {
        if (c.isActive()) {
            c.setActive(false);
            this.c.save(c);
        }
        return c;
    }

    @Override
    public BigDecimal getSumPayments(Long id) {
        return c.getSumPayments(id);
    }
}
