package com.example.springboottest.response;


import com.example.springboottest.entity.Customer;

public class CustomRequestBody {
    private Customer user;

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }
}
