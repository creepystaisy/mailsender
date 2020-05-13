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
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


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
    public void cronJob() throws MessagingException {

        Collection<User> users = (Collection<User>) userRepository.findAll();
        logger.info("Start");
        for(User user : users)
        {
            logger.info(user.getEmail());
            MimeMessage message = emailSender.createMimeMessage();

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");


            String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                    +"";

            message.setContent(htmlMsg , "text/html");

            helper.setTo(user.getEmail());

            helper.setSubject(topic);


            this.emailSender.send(message);



            logger.info("Email Sent!");
        }
    }
}