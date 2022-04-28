package com.example.helloworld.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {
    Record record;

    public void setup(){
        record = new Record();
        record.setId(12);
        record.setReputation("great");
        record.setComment("This is a bad experience");
        record.setTime("2022-02-01 12:00");
        record.setUse_easy("No");
    }

    @Test
    public void TestCreate(){
        setup();
        assertEquals(12,record.getId());
        assertEquals("great",record.getReputation());
        assertEquals("This is a bad experience",record.getComment());
        assertEquals("2022-02-01 12:00",record.getTime());
        assertEquals("No",record.getUse_easy());
    }
}