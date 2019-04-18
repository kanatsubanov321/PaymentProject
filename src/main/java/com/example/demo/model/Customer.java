package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isActive;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Customer() {
    }

    public Customer(Long id, String name, boolean isActive, String phone, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.phone = phone;
        this.wallet = wallet;
    }

    public Customer(String name, boolean isActive, String phone, Wallet wallet) {
        this.name = name;
        this.isActive = isActive;
        this.phone = phone;
        this.wallet = wallet;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
