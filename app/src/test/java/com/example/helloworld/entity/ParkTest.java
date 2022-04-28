package com.example.helloworld.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkTest {
    Park park;
    public void setup(){
        park = new Park();
        park.setPark_name("ABD park");
        park.setId(0);
        park.setCost(12);
        park.setLocation("London, UK");}

    @Test
    public  void CreateTest(){
        setup();
        assertEquals("ABD park",park.getPark_name());
        assertEquals(0,park.getId());
        assertEquals("London, UK",park.getLocation());
        assertEquals(12,park.getCost(),0.0001);

    }

}