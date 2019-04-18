package com.example.demo.model;

import com.example.demo.enums.Status;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "payment")
public class Payment {
    public static Random r = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Status status;

    private BigDecimal amount;

    private int confirmationCode;

    @ManyToOne
    @JoinColumn(name = "internet_id")
    private Internet internet;

    private LocalDateTime time;

    public Payment() {
    }

    public Payment(Long id, Status status, BigDecimal amount) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public Payment(BigDecimal amount, Internet internet) {
        this.amount = amount;
        this.internet = internet;

        this.time = LocalDateTime.now();

        if (amount.remainder(BigDecimal.valueOf(2))
                .equals(BigDecimal.ZERO)) {
            setStatus(Status.Waiting);
            this.confirmationCode = r.nextInt(9999);
        } else {
            setStatus(Status.Error);
        }
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
