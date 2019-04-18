package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CustomerService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController extends HttpServlet {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    private List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    private Payment getOnePayment(@PathVariable Long id,
                                  @RequestHeader(name = "customer-phone") String customerPhone) {
        if (!customerService.checkCustomerPhone(id, customerPhone)) {
            return null;
        }
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Payment addPayment(@RequestBody Payment c) {
        return paymentService.addPayment(c);
    }

    //    @PostMapping("/confirm/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.POST)
    private void confirm(@RequestBody ConfirmationCode code, Payment payment,
                         Customer customer, Wallet wallet, Internet internet,
                         HttpServletResponse resp,
                         @PathParam("/{id}") Long id) throws Exception {
        boolean result = true;
        try {
            paymentService.addConfirmationCode(code, payment, customer, wallet, internet);
            if (!paymentService.addConfirmationCode(code, payment, customer, wallet, internet)) {
                result = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        PrintWriter out = resp.getWriter();
        out.println(result ? "You have successfully paid for the Internet" : "You entered an incorrect confirmation code");
    }
}