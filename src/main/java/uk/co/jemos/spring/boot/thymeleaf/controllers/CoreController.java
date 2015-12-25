package uk.co.jemos.spring.boot.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.jemos.spring.boot.thymeleaf.email.CustomerMailSender;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * Created by tedonema on 25/12/2015.
 */
@Controller
public class CoreController {

    @Resource
    private CustomerMailSender customerMailSender;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/payload")
    public String payload() {
        return "payload";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/emailMe")
    public String emailMe() throws MessagingException {
        customerMailSender.send("marco.tedone@gmail.com", "Hello, World", "Mail From Spring");
        return "index";
    }
}
