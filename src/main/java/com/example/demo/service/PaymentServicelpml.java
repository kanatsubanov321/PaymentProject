package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServicelpml implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment p) {
        return this.paymentRepository.save(p);
    }

    @Override
    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentRepository.findById(id).get();
    }

}
