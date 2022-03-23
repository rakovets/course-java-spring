package by.rakovets.course.java.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showIndexView() {
        return "index";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}
