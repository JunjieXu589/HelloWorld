package com.example.helloworld.entity;

public class Customer extends User{
    private String payment;
    private float bal;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public float getBal() {
        return bal;
    }

    public void setBal(float bal) {
        this.bal = bal;
    }
}
