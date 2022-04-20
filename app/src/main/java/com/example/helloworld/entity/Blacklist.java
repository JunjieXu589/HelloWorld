package com.example.helloworld.entity;


import org.litepal.crud.LitePalSupport;

public class Blacklist extends LitePalSupport {
    private Customer customer;
    private Park park;

    //原本的设计有一个boolean来表示是否在blacklist中
    // 但这样会导致增加park时必须同时增加blacklist 所以去掉

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

}
