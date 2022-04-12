package com.example.helloworld.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    Session session;
    public void setUp(){
        session = new Session();

    }

    @Test
    public void SessionTest(){
        setUp();

        session.setUserID("12334@email.com");
        assertEquals("12334@email.com",session.getUserID());
        session.setUserID("10000");
        assertEquals("10000",session.getUserID());

    }
}