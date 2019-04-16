package com.example.demo.service;

import com.example.demo.model.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAllWallets();
    Wallet findWalletById(Long id);
    Wallet saveWallet(Wallet w);
    void updateWallet(Wallet w);
    void deleteWalletById(Long id);
    void deleteAllWallets();

}
