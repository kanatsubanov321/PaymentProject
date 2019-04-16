package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime time;

    public Payment() {
    }

    public Payment(Long id, String status, BigDecimal amount, Customer client) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.customer = client;

        this.time = LocalDateTime.now();
    }

    public Payment(BigDecimal amount, Customer client) {
        this.amount = amount;
        this.customer = client;

        this.time = LocalDateTime.now();

        if (amount.remainder(BigDecimal.valueOf(2))
                .equals(BigDecimal.ZERO)){
            this.status = "OK";
        }
        else {
            this.status = "ERROR";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
