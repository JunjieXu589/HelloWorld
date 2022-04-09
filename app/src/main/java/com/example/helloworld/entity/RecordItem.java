package com.example.helloworld.entity;

public class RecordItem {
    private String parkName;
    private String recordTime;
    //private int image;//不知道能否用到 也许用cardview会用不到，，可能还要加reputation来判断用娜张图


    public RecordItem(String parkName, String recordTime) {//constructor
        this.parkName = parkName;
        this.recordTime = recordTime;
    }

    //getter 和setter
    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}
