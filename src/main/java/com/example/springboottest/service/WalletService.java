package com.example.springboottest.service;

import com.example.springboottest.dao.WalletRepository;
import com.example.springboottest.entity.Wallet;
import com.example.springboottest.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class WalletService implements IBaseService<Wallet> {

    @Autowired
    private WalletRepository repository;

    @Override
    public Wallet insert(Wallet entity) {
        entity.setCreatedDate(Utility.getCurrentDateTime());
        entity.setModifiedDate(Utility.getCurrentDateTime());
        repository.insert(entity);
        return entity;
    }

    @Override
    public Wallet update(Wallet entity) {
//        repository.updateLimit(entity.getWalletId(),entity.getWalletLimit());
        return entity;
    }


    @Override
    public List<Wallet> findAll() {
        return null;
    }

    @Override
    public Wallet findById(BigInteger id) {
        return repository.findById(id);
    }

    public int updateLimit(final BigInteger walletId, final BigDecimal walletLimit) {
        return repository.updateLimit(walletId, walletLimit);
    }

    public int updateBalance(final BigInteger walletId,
                             final BigDecimal walletBalance,
                             final int walletPoint) {
        return repository.updateBalance(walletId, walletBalance, walletPoint);
    }
}
