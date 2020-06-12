package com.example.MailSender.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
@ConfigurationProperties(prefix = "emailsender.email.emailconstants")
public class MailConfig {


    String myemail;
    String password;

    public String getMyemail() {
        return myemail;
    }

    public String getPassword() {
        return password;
    }

    public void setMyemail(String myemail) {
        this.myemail = myemail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        
        mailSender.setUsername(myemail);
        mailSender.setPassword(password);
        System.out.println("TEST!!! "+myemail+" "+password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
