package com.example.MailSender.controller;

import com.example.MailSender.batch.BatchBean;
import com.example.MailSender.model.User;
import com.example.MailSender.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
class MainControllerTest  {
    @MockBean
    private UserRepository repository;
    @Autowired
    private MainController mainController;

    @Test
    void addNewUser() {
        User user = new User("123", "123@mail.ru");
        assertEquals("123", user.getName());
        assertEquals("123@mail.ru", user.getEmail());
    }
    @Test
    void addNewUser1() {
        mainController.addNewUser("123","123@mail.ru");
        System.out.println(repository.findById(1)+"TESTTT");

    }

    @Test
    void getAllUsers() {
        
    }

  /*  @Test
    void getOne() {
        mainController.addNewUser("123","123@mail.ru");
        assertEquals("123", repository.findById(1).get());
        assertEquals("123@mail.ru", user.getEmail());
    }

    @Test
    void getOneTest() throws Exception{

        repository.save(new User(1, "123", "123@mail.ru"));
        Optional<User> fromDb = repository.findById(1);
        Assertions.assertThat(fromDb.getName()).isEqualTo("123");

    }
*/
    @Test
    void deleteOne() {
    }

    @Test
    void putOne() {
    }
}