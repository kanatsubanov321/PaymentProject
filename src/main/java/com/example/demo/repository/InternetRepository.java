package com.example.demo.repository;

import com.example.demo.model.Internet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternetRepository
        extends JpaRepository<Internet,Long> {
}
