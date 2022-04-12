package com.example.helloworld.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;

    public void setup(){
        customer = new Customer();
        customer.setUserID("1234567");
        customer.setPwd("waspass");
        customer.setBalance(150);
        customer.setCar("京A23451");
        customer.setPayment("152728484384648395");
        customer.setTelephone("17735633107");

    }

    @Test
    public void TestCreate(){
        setup();
        assertEquals("1234567",customer.getUserID());
        customer.setUserID("jackMa@bupt.edu.cn");
        assertEquals("jackMa@bupt.edu.cn",customer.getUserID());

        assertEquals("waspass",customer.getPwd());
        customer.setPwd("121");
        assertEquals("121",customer.getPwd());

        assertEquals(150,customer.getBalance(),0.00001);
        customer.setBalance(0);
        assertEquals(0,customer.getBalance(),0.00001);

        assertEquals("京A23451",customer.getCar());
        customer.setCar("WB23451");
        assertEquals("WB23451",customer.getCar());

        assertEquals("152728484384648395",customer.getPayment());
        customer.setPayment("6227-2844-4384-6395-782");
        assertEquals("6227-2844-4384-6395-782",customer.getPayment());

        assertEquals("17735633107",customer.getTelephone());
        customer.setTelephone("+86 13335633107");
        assertEquals("+86 13335633107",customer.getTelephone());
    }
}