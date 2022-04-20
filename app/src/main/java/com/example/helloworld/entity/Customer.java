package com.example.helloworld.entity;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Customer extends LitePalSupport {
    //据说litePal会自动给表加一个id
    protected String userID;
    protected String pwd;
    private String payment;
    private String car;//用于存车牌号?
    private float balance;
    private String Telephone;

    private List<Blacklist> blacklistList;//建立表关联
    private List<Record> recordList;//为了表明customer与record的关系是一对多


    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}

    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {this.pwd = pwd;}

    public String getPayment() {return payment;}
    public void setPayment(String payment) {this.payment = payment;}

    public String getCar() {return car;}
    public void setCar(String car) {this.car = car;}

    public float getBalance() {return balance;}
    public void setBalance(float balance) {this.balance = balance;}

    public String getTelephone() {return Telephone;}
    public void setTelephone(String telephone) {Telephone = telephone;}

    public List<Blacklist> getBlacklistList() {
        return blacklistList;
    }

    public void setBlacklistList(List<Blacklist> blacklistList) {
        this.blacklistList = blacklistList;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

}
