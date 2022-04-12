package com.example.helloworld.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordItemTest {

    RecordItem record;
    public void setup(){
        record = new RecordItem("BUPT School Park","2022-01-23 12:00");
    }

    @Test
    public void CreateTest(){
        setup();
        assertEquals("BUPT School Park",record.getParkName());
        assertEquals("2022-01-23 12:00",record.getRecordTime());
        record.setRecordTime("1990-0-11 12:00");
        record.setParkName("1234");
        assertEquals("1990-0-11 12:00",record.getRecordTime());
        assertEquals("1234",record.getParkName());


    }
}