package com.example.helloworld.entity;

import org.litepal.crud.LitePalSupport;

public class Record extends LitePalSupport {//它与park或user均为多对1的关系
    private int id;
    private Park park;//This is reflected in the database as the park_id attribute
    private Customer customer;//这里意在引用user_id
    private String time;
    private String comment;
    private String use_easy;
    private String reputation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUse_easy() {
        return use_easy;
    }

    public void setUse_easy(String use_easy) {
        this.use_easy = use_easy;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }




}
