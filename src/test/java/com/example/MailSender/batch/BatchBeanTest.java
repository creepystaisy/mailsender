package com.example.MailSender.batch;




import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatchBeanTest {
    private BatchBean batch;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("");
        System.out.println("Before BatchBean.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("");
        System.out.println("After BatchBean.class");
    }

    @Before
    public void initTest() {
        System.out.println("");
        System.out.println("initTest()");
        batch = new BatchBean();
    }

    @After
    public void afterTest() {
        System.out.println("afterTest()");
        batch = null;
    }

    @Test
    void getTopic() {
        System.out.println("getTopic()");
    }

    @Test
    void getText() {
        System.out.println("getText()");
    }

    @Test
    void setTopic() {
        System.out.println("setTopic()");
    }

    @Test
    void setText() {
        System.out.println("setText()");
    }

    @Test
    void cronJob() {
        System.out.println("cronJob()");
    }
}