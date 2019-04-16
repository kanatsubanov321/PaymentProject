package com.example.demo.service;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServicelmpl implements WalletService {
    @Autowired
    private WalletRepository w;

    @Override
    public List<Wallet> findAllWallets() {
        return w.findAll();
    }

    @Override
    public Wallet findWalletById(Long id) {
        return w.findById(id).get();
    }

    @Override
    public Wallet saveWallet(Wallet w) {
        return this.w.save(w);
    }

    @Override
    public void updateWallet(Wallet w) {
        this.w.save(w);
    }

    @Override
    public void deleteWalletById(Long id) {
        w.deleteById(id);
    }

    @Override
    public void deleteAllWallets() {
        w.deleteAll();
    }
}
