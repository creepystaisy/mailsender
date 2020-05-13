package com.example.MailSender.model;

import com.example.MailSender.controller.MainController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("");
        System.out.println("Before User.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("");
        System.out.println("After User.class");
    }

    @Before
    public void initTest() {
        System.out.println("");
        System.out.println("initTest()");
        user = new User();
    }

    @After
    public void afterTest() {
        System.out.println("afterTest()");
        user = null;
    }

    @Test
    void getId() {
        System.out.println("getId()");
    }

    @Test
    void setId() {
        System.out.println("setId()");
    }

    @Test
    void getName() {
        System.out.println("getName()");
    }

    @Test
    void setName() {
        System.out.println("setName()");
    }

    @Test
    void getEmail() {
        System.out.println("getEmail()");
    }

    @Test
    void setEmail() {
        System.out.println("setEmail()");
    }
}