package uk.co.jemos.spring.boot.thymeleaf.email;

import javax.mail.MessagingException;

/**
 * Created by tedonema on 21/12/2015.
 */
public interface CustomerMailSender {
    void send(String to, String subject, String body) throws MessagingException;
}
