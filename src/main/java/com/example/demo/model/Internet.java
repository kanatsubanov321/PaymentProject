package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Internet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int sum;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Internet() {
    }

    public Internet(Long id, String name, int sum, Customer customer) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.customer = customer;
    }

    public Internet(String name, int sum, Customer customer) {
        this.name = name;
        this.sum = sum;
        this.customer = customer;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
