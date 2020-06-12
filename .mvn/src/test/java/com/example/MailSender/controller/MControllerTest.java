package com.example.MailSender.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MControllerTest {
    /* @Test
       public void greetingShouldReturnDefaultMessage() throws Exception {
           assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                   String.class)).contains("Hello, World");
       }*/
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void home()throws Exception  {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/users/new",
                String.class)).contains("home");
    }

    @Test
    void addedUser() {
    }
}