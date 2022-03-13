package by.rakovets.course.java.spring.webmvc.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class DemoController {

    @GetMapping(path = "/demo/{id}")
    public String showDemoPage(@RequestHeader("Authorization") String authorizationHeader,
                               @CookieValue("JSESSIONID") String sessionId,
                               @RequestParam("username") String username,
                               @PathVariable("id") int id) {
        System.out.println(authorizationHeader);
        System.out.println(sessionId);
        System.out.println(username);
        System.out.println(id);
        return "demo";
    }

    @PostMapping(path = "/demo")
    public String showPostDemoPage(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "demo";
    }
}
