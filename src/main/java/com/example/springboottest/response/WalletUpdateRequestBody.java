package com.example.springboottest.response;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WalletUpdateRequestBody {
    private BigInteger userId;
    private BigDecimal balance;
    private BigDecimal limit;
    private Integer pointer;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Integer getPointer() {
        return pointer;
    }

    public void setPointer(Integer pointer) {
        this.pointer = pointer;
    }
}
