package com.example.demo.bootstrap;

import com.example.demo.model.Customer;
import com.example.demo.model.Payment;
import com.example.demo.model.Wallet;
import com.example.demo.service.CustomerService;

import com.example.demo.service.PaymentService;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception {

        Wallet wallet = new Wallet("ElKart", 10000);
        walletService.saveWallet(wallet);
        Wallet wallet1 = new Wallet("ElSom", 15000);
        walletService.saveWallet(wallet1);
        Wallet wallet2 = new Wallet("Visa", 5000);
        walletService.saveWallet(wallet2);
        Wallet wallet3 = new Wallet("Visa", 7000);
        walletService.saveWallet(wallet3);

        Customer customer = new Customer("Islam Turanov", true, wallet);
        customerService.saveCustomer(customer);
        Customer customer1 = new Customer("Kanat Subanov", true, wallet1);
        customerService.saveCustomer(customer1);
        Customer customer2 = new Customer("Uluk Aliev", false, wallet2);
        customerService.saveCustomer(customer2);
        Customer customer3 = new Customer("Altyn Samiev", false, wallet3);
        customerService.saveCustomer(customer3);

        Payment payment = new Payment(BigDecimal.TEN, customer);
        paymentService.addPayment(payment);

    }
}
