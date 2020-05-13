package com.example.MailSender.config;

import com.example.MailSender.batch.BatchBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailConfigTest {

    private MailConfig config;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("");
        System.out.println("Before MailConfig.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("");
        System.out.println("After MailConfig.class");
    }

    @Before
    public void initTest() {
        System.out.println("");
        System.out.println("initTest()");
        config = new MailConfig();
    }

    @After
    public void afterTest() {
        System.out.println("afterTest()");
        config = null;
    }
    @Test
    void getMyemail() {
        System.out.println("getMyemail()");
    }

    @Test
    void getPassword() {
        System.out.println("getPassword()");
    }

    @Test
    void setMyemail() {
        System.out.println("setMyemail()");
    }

    @Test
    void setPassword() {
        System.out.println("setPassword()");
    }

    @Test
    void getJavaMailSender() {
        System.out.println("getJavaMailSender()");
    }
}