package com.example.springboottest.service;

import com.example.springboottest.dao.CustomerRepository;
import com.example.springboottest.entity.Customer;
import com.example.springboottest.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CustomerService implements IBaseService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer insert(Customer entity) {
        entity.setCreatedDate(Utility.getCurrentDateTime());
        entity.setModifiedDate(Utility.getCurrentDateTime());
        repository.insert(entity);
        return entity;
    }

    @Override
    public Customer update(Customer entity) {
        repository.update(entity);
        return entity;
    }


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(BigInteger id) {
        return repository.findById(id);
    }
}
