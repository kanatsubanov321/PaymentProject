package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer c);

    void deleteCustomerById(Long id);

    void deleteAllCustomers();

    Customer updateCustomer(Customer c);

    BigDecimal getSumPayments(Long id);

    boolean checkCustomerPhone(Long id, String phone);

    int getCustomerBalance(Long id);

    int getCustomerPhone(Long id);

    int getCustomerConfirmationCode(Long id);

    List<Object[]> getCustomerInfo(Long id);


}
