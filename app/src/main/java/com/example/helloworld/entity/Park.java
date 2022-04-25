package com.example.helloworld.entity;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Park extends LitePalSupport {
    private int id;
    private String park_name;
    private float cost;
    private String location;

    private List<Record> recordlist;//为了建立表关系  park与record是1对多关系
    private List<Blacklist> blacklistList;//park与blacklist是一对多关系

    public Park() {//默认构造函数
    }

    //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPark_name() {
        return park_name;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Record> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(List<Record> recordlist) {
        this.recordlist = recordlist;
    }

    public List<Blacklist> getBlacklistList() {
        return blacklistList;
    }

    public void setBlacklistList(List<Blacklist> blacklistList) {
        this.blacklistList = blacklistList;
    }


    public Park(String park_name,String location, float cost){//构造函数
        this.cost = cost;
        this.location = location;
        this.park_name = park_name;
    }

}
