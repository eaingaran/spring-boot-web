package uk.co.jemos.spring.boot.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import uk.co.jemos.spring.boot.thymeleaf.email.CustomerMailSender;
import uk.co.jemos.spring.boot.thymeleaf.email.MockCustomerMailSender;
import uk.co.jemos.spring.boot.thymeleaf.email.SmtpCustomerMailSender;

/**
 * Created by tedonema on 21/12/2015.
 */
@Configuration
public class MailConfig {

    @Bean
    @Profile("dev")
    public CustomerMailSender mockMailSender() {
        return new MockCustomerMailSender();
    }

    @Bean
    @Profile("prod")
    public CustomerMailSender smtpMailSender() {
        return new SmtpCustomerMailSender();
    }


}
