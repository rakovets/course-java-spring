package by.rakovets.course.java.spring.webmvc.view.controller;

import by.rakovets.course.java.spring.webmvc.view.dal.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.MimeType;
import java.net.http.HttpHeaders;

@Controller
public class RegistrationController {

    @GetMapping(path = "/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping(
            path = "/registration",
            consumes = {"application/json"},
            produces = {"text/html"}
    )
    public String registerUser(@RequestHeader("Content-type") String header,
                                  @RequestBody User user) {
        System.out.println(user);
        return "registration";
    }
}
