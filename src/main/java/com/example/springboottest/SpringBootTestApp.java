package com.example.springboottest;

import com.example.springboottest.entity.Customer;
import com.example.springboottest.entity.Wallet;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@MappedTypes({
        Customer.class,
        Wallet.class,
})
@MapperScan("com.example.springboottest.dao")

@SpringBootApplication
@ComponentScan("com.example.springboottest")
@EnableAutoConfiguration

public class SpringBootTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApp.class, args);
    }

}
