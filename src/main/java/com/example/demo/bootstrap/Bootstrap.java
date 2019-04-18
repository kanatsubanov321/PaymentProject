package com.example.demo.bootstrap;

import com.example.demo.model.Customer;
import com.example.demo.model.Internet;
import com.example.demo.model.Payment;
import com.example.demo.model.Wallet;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InternetService;
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

    @Autowired
    private InternetService internetService;

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

        Customer customer = new Customer("Kanat Subanov", false, "222", wallet);
        customerService.saveCustomer(customer);
        Customer customer1 = new Customer("Islam Egemberdiev", false, "777", wallet1);
        customerService.saveCustomer(customer1);
        Customer customer2 = new Customer("Uluk Aliev", false, "555", wallet2);
        customerService.saveCustomer(customer2);
        Customer customer3 = new Customer("Altyn Samiev", false, "707", wallet3);
        customerService.saveCustomer(customer3);

        Internet internet = new Internet("Megaline", 800, customer);
        internetService.saveInternet(internet);

        Internet internet1 = new Internet("Aknet", 1200, customer1);
        internetService.saveInternet(internet1);

        Internet internet2 = new Internet("Homeline", 1000, customer2);
        internetService.saveInternet(internet2);

        Payment payment = new Payment(BigDecimal.TEN, internet);
        paymentService.addPayment(payment);

        Payment payment1 = new Payment(BigDecimal.ONE, internet1);
        paymentService.addPayment(payment1);
    }
}
