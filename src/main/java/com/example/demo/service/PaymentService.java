package com.example.demo.service;

import com.example.demo.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment p);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
}
