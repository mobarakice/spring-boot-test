package com.example.springboottest.service;

import java.math.BigInteger;
import java.util.List;


public interface IBaseService<T> {

    T insert(T entity);

    T update(T entity);

    List<T> findAll();

    T findById(BigInteger id);

}
