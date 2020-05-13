package com.example.MailSender.controller;

import com.example.MailSender.config.MailConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    private MainController controller;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("");
        System.out.println("Before MainController.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("");
        System.out.println("After MainController.class");
    }

    @Before
    public void initTest() {
        System.out.println("");
        System.out.println("initTest()");
        controller = new MainController();
    }

    @After
    public void afterTest() {
        System.out.println("afterTest()");
        controller = null;
    }

    @Test
    void addNewUser() {
        System.out.println("addNewUser()");
    }

    @Test
    void testAddNewUser() {
        System.out.println("testAddNewUser()");
    }

    @Test
    void getAllUsers() {
        System.out.println("getAllUsers()");
    }

    @Test
    void getOne() {
        System.out.println("getOne()");
    }

    @Test
    void deleteOne() {
        System.out.println("deleteOne()");
    }

    @Test
    void putOne() {
        System.out.println("putOne()");
    }
}