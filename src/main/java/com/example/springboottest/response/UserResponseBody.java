package com.example.springboottest.response;

import com.example.springboottest.entity.Customer;

public class UserResponseBody extends SuccessResponse<UserResponseBody> {

    private Customer user;

    public Customer getUser() {
        return user;
    }

    public UserResponseBody setUser(Customer user) {
        this.user = user;
        return this;
    }
}
