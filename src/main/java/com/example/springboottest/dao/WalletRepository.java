package com.example.springboottest.dao;

import com.example.springboottest.entity.Wallet;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Mapper
public interface WalletRepository {

    @Insert("INSERT INTO wallet_table (wallet_id, wallet_balance, wallet_limit, " +
            "wallet_point, created_date, created_by, modified_date, modified_by) " +
            "VALUES (null, #{walletId}, #{walletBalance}, #{walletLimit}, #{walletPoint}, " +
            "#{createdDate},  #{createdBy}, #{modifiedDate}, #{modifiedBy})")
    @Options(useGeneratedKeys = true, keyProperty = "walletId", keyColumn = "wallet_id")
    int insert(Wallet wallet);

    @Update("UPDATE Wallet SET wallet_limit = #{walletLimit}, WHERE wallet_id = #{walletId}")
    int updateLimit(@Param("walletId") BigInteger walletId, @Param("walletLimit") BigDecimal walletLimit);

    @Update("UPDATE Wallet SET wallet_balance = #{walletBalance}, wallet_point = #{walletPoint}, " +
            "WHERE wallet_id = #{walletId}")
    int updateBalance(@Param("walletId") BigInteger walletId,
                      @Param("walletBalance") BigDecimal walletBalance,
                      @Param("walletPoint") int walletPoint);

    @Select("SELECT * FROM wallet_table WHERE wallet_id = #{walletId}")
    Wallet findById(@Param("walletId") BigInteger walletId);
}
