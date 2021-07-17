package com.example.springboottest.response;


import java.util.ArrayList;
import java.util.List;

public class CustomerResponseBody extends SuccessResponse<CustomerResponseBody> {

    private List<CustomerModel> customers;

    public List<CustomerModel> getCustomers() {
        return customers;
    }

    public CustomerResponseBody setCustomer(List<CustomerModel> customers) {
        this.customers = customers;
        return this;
    }

    public CustomerResponseBody add(CustomerModel customer) {
        this.customers = new ArrayList<>();
        this.customers.add(customer);
        return this;
    }
}
