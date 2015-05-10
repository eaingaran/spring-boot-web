package uk.co.jemos.experiments.spring.boot.mvc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tedonema on 09/05/2015.
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    /* --Uncomment to run this as a standalone jar file from the command line
    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
    */
}
