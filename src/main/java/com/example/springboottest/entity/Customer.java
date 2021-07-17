package com.example.springboottest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "user_table")
public class Customer extends BaseEntity<Customer>{
    @Id
    @Column(name = "user_id")
    private BigInteger userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "address_1")
    private String addressOne;
    @Column(name = "address_2")
    private String addressTw0;
    @Column(name = "address_3")
    private String addressThree;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "mykad_nbr")
    private String mykadNbr;
    @Column(name = "gender")
    private String gender;
    @Column(name = "wallet_id")
    private BigInteger walletId;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTw0() {
        return addressTw0;
    }

    public void setAddressTw0(String addressTw0) {
        this.addressTw0 = addressTw0;
    }

    public String getAddressThree() {
        return addressThree;
    }

    public void setAddressThree(String addressThree) {
        this.addressThree = addressThree;
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

    public String getMykadNbr() {
        return mykadNbr;
    }

    public void setMykadNbr(String mykadNbr) {
        this.mykadNbr = mykadNbr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getWalletId() {
        return walletId;
    }

    public void setWalletId(BigInteger walletId) {
        this.walletId = walletId;
    }

}
