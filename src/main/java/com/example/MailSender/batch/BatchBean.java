package com.example.MailSender.batch;


import java.util.Collection;

//import org.example.ws.model.Greeting;
//import org.example.ws.service.GreetingService;
import com.example.MailSender.model.User;
import com.example.MailSender.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "emailsender.email.content")
public class BatchBean {
    String topic;
    String text;

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setText(String text) {
        this.text = text;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender emailSender;


    @Scheduled(cron = "${emailsender.schedule.cron}" )
    public void cronJob() {

        Collection<User> users = (Collection<User>) userRepository.findAll();
        logger.info("Start");
        for(User user : users)
        {
            logger.info(user.getEmail());
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(user.getEmail());

            message.setSubject(topic);
            message.setText(text);

            // Send Message!
            this.emailSender.send(message);

            logger.info("Email Sent!");
        }
    }
}