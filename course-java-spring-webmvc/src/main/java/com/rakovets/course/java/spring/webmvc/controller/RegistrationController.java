package com.rakovets.course.java.spring.webmvc.controller;

import com.rakovets.course.java.spring.webmvc.dal.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RegistrationController {

    @GetMapping(path = "/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registerUser(@SessionAttribute User user) {
        System.out.println(user);
        return "redirect:/registration";
    }
}
