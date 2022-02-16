package by.rakovets.course.java.spring.webmvc.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    @GetMapping("/animations")
    public String showTestPage() {
        return "animations";
    }
}
