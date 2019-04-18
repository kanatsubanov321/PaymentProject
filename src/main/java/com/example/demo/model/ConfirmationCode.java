package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConfirmationCode {
    @Id
    private Long id;
    private int confirmationCode;

    public ConfirmationCode() {
    }

    public ConfirmationCode(Long id, int confirmationCode) {
        this.id = id;
        this.confirmationCode = confirmationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
