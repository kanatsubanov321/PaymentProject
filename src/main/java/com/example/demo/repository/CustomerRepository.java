package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
    @Query(value = "select sum(p.amount) from Payment " +
            "p inner join p.internet i inner join i.customer c where c.id = :customer_id")
    BigDecimal getSumPayments(@Param("customer_id") Long customer_id);

    @Query(value = "select w.sum from Customer " +
            "c inner join c.wallet w where c.id = :customer_id")
    int getCustomerBalance(@Param("customer_id") Long customer_id);

    @Query(value = "select c.phone from Customer " +
            "c where c.id = :customer_id")
    int getCustomerPhone(@Param("customer_id") Long customer_id);

    @Query(value = "select p.confirmationCode from Payment " +
            "p inner join p.internet i inner join i.customer c where c.id = :customer_id")
    int getCustomerConfirmationCode(@Param("customer_id") Long customer_id);

    @Query(value = "select p.confirmationCode, p.status, c.name, i.name, i.sum from Payment " +
            "p inner join p.internet i inner join i.customer c where c.id = :customer_id")
    List<Object[]> getCustomerInfo(@Param("customer_id") Long customer_id);
}
