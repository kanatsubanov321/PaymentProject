package com.example.demo.service;

import com.example.demo.enums.Status;
import com.example.demo.model.*;
import com.example.demo.repository.ConfirmationCodeRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServicelpml implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ConfirmationCodeRepository confirmationCodeRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired InternetService internetService;

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

    @Override
    public boolean addConfirmationCode(ConfirmationCode code, Payment payment,
                                       Customer customer, Wallet wallet, Internet internet) {
        confirmationCodeRepository.save(code);
        if (code.getConfirmationCode() == paymentService.getPaymentById(payment.getId()).getConfirmationCode()) {
            paymentService.getPaymentById(payment.getId()).setStatus(Status.Ok);
            customerService.findCustomerById(customer.getId()).setActive(true);
            customerService.findCustomerById(customer.getId()).getWallet().
                    setSum(customerService.findCustomerById(customer.getId()).getWallet().getSum()
                            - internetService.findInternetById(internet.getId()).getSum());
            return true;
        }
        return false;
    }
}
