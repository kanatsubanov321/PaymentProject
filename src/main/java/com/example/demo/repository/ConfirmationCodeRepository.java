package com.example.demo.repository;

import com.example.demo.model.ConfirmationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationCodeRepository
        extends JpaRepository<ConfirmationCode,Long> {
}
