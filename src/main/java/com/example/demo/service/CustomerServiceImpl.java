package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository c;

    private final CustomerService customerService;

    public CustomerServiceImpl(CustomerRepository c, CustomerService customerService) {
        this.c = c;
        this.customerService = customerService;
    }

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
    public void deleteCustomerById(Long id) {
        c.deleteById(id);
    }

    @Override
    public void deleteAllCustomers() {
        c.deleteAll();
    }


    @Override
    public Customer updateCustomer(Customer c) {
        return this.c.save(c);
    }

    @Override
    public BigDecimal getSumPayments(Long id) {
        return c.getSumPayments(id);
    }

    @Override
    public boolean checkCustomerPhone(Long id, String phone) {
        return customerService.findCustomerById(id).getPhone().equals(phone);
    }

    @Override
    public int getCustomerBalance(Long id) {
        return c.getCustomerBalance(id);
    }

    @Override
    public int getCustomerPhone(Long id) {
        return c.getCustomerPhone(id);
    }

    @Override
    public int getCustomerConfirmationCode(Long id) {
        return c.getCustomerConfirmationCode(id);
    }

    @Override
    public List<Object[]> getCustomerInfo(Long id) {
        return c.getCustomerInfo(id);
    }
}
