package com.example.springboottest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "wallet_table")
public class Wallet extends BaseEntity<Wallet> {
    @Id
    @Column(name = "wallet_id")
    private BigInteger walletId;

    @Column(name = "wallet_balance")
    private BigDecimal walletBalance;

    @Column(name = "wallet_limit")
    private BigDecimal walletLimit;

    @Column(name = "wallet_point")
    private int walletPoint;

    public BigInteger getWalletId() {
        return walletId;
    }

    public void setWalletId(BigInteger walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public BigDecimal getWalletLimit() {
        return walletLimit;
    }

    public void setWalletLimit(BigDecimal walletLimit) {
        this.walletLimit = walletLimit;
    }

    public int getWalletPoint() {
        return walletPoint;
    }

    public void setWalletPoint(int walletPoint) {
        this.walletPoint = walletPoint;
    }
}
