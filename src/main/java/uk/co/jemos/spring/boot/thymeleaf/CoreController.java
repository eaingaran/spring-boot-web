package uk.co.jemos.spring.boot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tedonema on 25/12/2015.
 */
@Controller
public class CoreController {

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
}
