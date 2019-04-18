package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment p);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    boolean addConfirmationCode(ConfirmationCode code, Payment payment,
                                Customer customer, Wallet wallet, Internet internet);

}
