package uk.co.jemos.spring.boot.thymeleaf.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by tedonema on 21/12/2015.
 */

public class SmtpCustomerMailSender implements CustomerMailSender {

    private static final Logger logger = LoggerFactory.getLogger(SmtpCustomerMailSender.class);

    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Override
    public void send(String to, String subject, String body) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);

        javaMailSender.send(mimeMessage);
        logger.info("Message sent successfully!");
    }


}
