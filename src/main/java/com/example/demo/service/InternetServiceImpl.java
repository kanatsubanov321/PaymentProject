package com.example.demo.service;

import com.example.demo.model.Internet;
import com.example.demo.repository.InternetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetServiceImpl implements InternetService {
    private final InternetRepository internetRepository;

    public InternetServiceImpl(InternetRepository internetRepository) {
        this.internetRepository = internetRepository;
    }

    @Override
    public List<Internet> findAllInternets() {
        return internetRepository.findAll();
    }

    @Override
    public Internet findInternetById(Long id) {
        return internetRepository.findById(id).get();
    }

    @Override
    public Internet saveInternet(Internet i) {
        return internetRepository.save(i);
    }

    @Override
    public void updateInternet(Internet i) {
        internetRepository.save(i);
    }

    @Override
    public void deleteInternetById(Long id) {
        internetRepository.deleteById(id);
    }

    @Override
    public void deleteAllInternets() {
        internetRepository.deleteAll();
    }
}
