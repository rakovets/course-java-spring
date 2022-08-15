package by.rakovets.course.java.spring.webmvc.rest.server.controller;

import by.rakovets.course.java.spring.webmvc.rest.server.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FormController {
    private static final AtomicLong counter = new AtomicLong();
    private final ObjectMapper objectMapper;

    @Autowired
    public FormController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "login", consumes = {"application/x-www-form-urlencoded"})
    public User login(@RequestBody MultiValueMap<String, String> params) {
        User user = new User();
        user.setId(counter.incrementAndGet());
        if (params.get("password") != null) {
            user.setPassword(params.get("password").get(0));
        }
        if (params.get("login") != null) {
            user.setPassword(params.get("login").get(0));
        }
        return user;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody User user) {
        return new User(counter.incrementAndGet(), user);
    }

    @PostMapping(value = "registration", consumes = {"application/x-www-form-urlencoded"})
    public User registration(@RequestBody MultiValueMap<String, String> params) {
        User user = new User();
        user.setId(counter.incrementAndGet());
        if (params.get("password") != null) {
            user.setPassword(params.get("password").get(0));
        }
        if (params.get("login") != null) {
            user.setPassword(params.get("login").get(0));
        }
        if (params.get("about-me") != null) {
            user.setAboutMe(params.get("about-me").get(0));
        }
        if (params.get("subscription") != null) {
            user.setSubscription(params.get("subscription").get(0).equals("on"));
        }
        return user;
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public String execute(@RequestBody MultiValueMap<String, String> params) throws JsonProcessingException {
        return objectMapper.writeValueAsString(params);
    }
}
