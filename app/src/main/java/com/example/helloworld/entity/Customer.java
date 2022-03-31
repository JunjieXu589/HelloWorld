package com.example.helloworld.entity;

import org.litepal.crud.LitePalSupport;

public class Customer extends LitePalSupport {
    //据说litePal会自动给表加一个id
    protected String userID;
    protected String pwd;
    private String payment;
    private String car;//用于存车牌号?
    private float balance;
    private String Telephone;

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
}
