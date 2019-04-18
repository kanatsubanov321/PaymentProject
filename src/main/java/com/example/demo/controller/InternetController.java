package com.example.demo.controller;


import com.example.demo.model.Internet;
import com.example.demo.service.InternetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/internet")
public class InternetController {
    @Autowired
    InternetService internetService;

    @GetMapping
    public List<Internet> getInternets() {
        return this.internetService.findAllInternets();
    }

    @GetMapping("/{id}")
    public Internet getInternetById(@PathVariable Long id) {
        return this.internetService.findInternetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Internet saveInternet(@RequestBody Internet i) {
        return this.internetService.saveInternet(i);
    }

    @PutMapping
    public void updateInternet(@RequestBody Internet i ) {
        this.internetService.saveInternet(i);
    }

    @DeleteMapping("/{id}")
    public void deleteInternetById(@PathVariable Long id) {
        this.internetService.deleteInternetById(id);
    }

    @DeleteMapping
    public void deleteAllInternets() {
        this.internetService.deleteAllInternets();
    }

}
