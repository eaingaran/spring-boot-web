package uk.co.jemos.spring.boot.thymeleaf.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tedonema on 21/12/2015.
 */

public class MockCustomerMailSender implements CustomerMailSender {

    private static final Logger logger = LoggerFactory.getLogger(MockCustomerMailSender.class);

    @Override
    public void send(String to, String subject, String body) {
        logger.info("Sending mock mail to: {} ", to);
        logger.info("Subject: {} ", subject);
        logger.info("Body: {} ", body);
    }

}
