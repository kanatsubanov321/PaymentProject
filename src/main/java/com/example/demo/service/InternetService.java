package com.example.demo.service;

import com.example.demo.model.Internet;

import java.util.List;

public interface InternetService {
    List<Internet> findAllInternets();
    Internet findInternetById(Long id);
    Internet saveInternet(Internet i);
    void updateInternet(Internet i);
    void deleteInternetById(Long id);
    void deleteAllInternets();

}
