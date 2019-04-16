package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Wallet;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<Wallet> getWallets() {
        return this.walletService.findAllWallets();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Long id) {
        return this.walletService.findWalletById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wallet saveWallet(@RequestBody Wallet w) {
        return this.walletService.saveWallet(w);
    }

    @PutMapping
    public void updateWallet(@RequestBody Wallet w) {
        this.walletService.saveWallet(w);
    }

    @DeleteMapping("/{id}")
    public void deleteWalletById(@PathVariable Long id) {
        this.walletService.deleteWalletById(id);
    }

    @DeleteMapping
    public void deleteAllWallets() {
        this.walletService.deleteAllWallets();
    }
}
