package com.example.MailSender.controller;

import com.example.MailSender.model.User;
import com.example.MailSender.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
public class SimpleTest {
    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private MainController mainController;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getOne1() throws Exception
    {


        // given
        User alex = new User(1,"alex","1");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        User found = userRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());
    }
    @Test
    public void test() throws Exception
    {
        assertThat(mainController).isNotNull();//Нормально ли подтянут контроллер
    }
    /*@Test
    public void test1() throws Exception
    {
        this.mockMvc.perform(get("/added"))
                .andDo(print())
                .andExpect(status().isOk())
        *//*.andExpect(content().string(containsString("addedUser")))*//*;
    }*/
    @Test
    public void test1() throws Exception
    {
        this.mockMvc.perform(get("/added"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andExpect(content().string(containsString("Thank you!")));
    }

    /*@Test
    public void getAllUsers() throws Exception
    {

        this.mockMvc.perform(get("/users/"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_XML));
        //.andExpect(MockMvcResultMatchers.xpath());*//*
    }*/
}
