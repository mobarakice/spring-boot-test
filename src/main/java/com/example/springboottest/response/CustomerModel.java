package com.example.springboottest.response;

import com.example.springboottest.entity.Customer;

import java.math.BigDecimal;

public class CustomerModel {
    private String shortName;
    private String address;
    private String phone;
    private String email;
    private BigDecimal balance;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static CustomerModel getCustomerModel(Customer customer) {
        CustomerModel model = new CustomerModel();
        model.setShortName(customer.getShortName());
        model.setEmail(customer.getEmail());
        model.setPhone(customer.getPhone());
        model.setAddress(customer.getAddressOne());
        return model;
    }
}
