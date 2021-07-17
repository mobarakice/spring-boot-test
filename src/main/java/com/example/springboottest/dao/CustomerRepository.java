package com.example.springboottest.dao;

import com.example.springboottest.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CustomerRepository {

    @Insert("INSERT INTO user_table (user_id, first_name, last_name, short_name, " +
            "address_1, address_2, address_3, mykad_nbr, gender, phone, email, " +
            "wallet_id, created_date, created_by, modified_date, modified_by) " +
            "VALUES (null, #{firstName}, #{lastName}, #{shortName}, #{addressOne}, " +
            "#{addressTwo}, #{addressThree}, #{mykadNbr}, #{gender}, #{phone}, #{email}, " +
            "#{walletId}, #{createdDate},  #{createdBy}, #{modifiedDate}, #{modifiedBy})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int insert(Customer customer);

    @Update("UPDATE user_table SET short_name = #{shortName}, address_1 = #{addressOne}, " +
            "address_2 = #{addressTwo}, address_3 = #{addressThree}, phone = #{phone}, " +
            "email = #{email}, WHERE user_id = #{userId}")
    int update(Customer customer);

    @Select("SELECT * FROM user_table WHERE user_id = #{userId}")
    Customer findById(@Param("userId") final BigInteger userId);

    @Select("SELECT * FROM Customer ORDER BY Customer.name ASC")
    List<Customer> findAll();
}
