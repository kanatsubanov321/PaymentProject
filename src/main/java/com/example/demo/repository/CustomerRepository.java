package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
    @Query(value = "select sum(p.amount) from Payment " +
            "p inner join p.customer c where c.id = :customer_id")
    BigDecimal getSumPayments(@Param("customer_id") Long customer_id);
}
