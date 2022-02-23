package by.rakovets.course.java.spring.webmvc.rest.controller;

import by.rakovets.course.java.spring.webmvc.rest.dto.User;
import by.rakovets.course.java.spring.webmvc.rest.dto.ValidationMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("login")
public class LoginController {
    @GetMapping
    public String openLoginPage() {
        return "login";
    }

    @PostMapping
    @ResponseBody
    public ValidationMessage login(@Valid @RequestBody User user, Errors errors) {
        if (StringUtils.isEmpty(user.getUsername())) {
            return new ValidationMessage("Username is not defined");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new ValidationMessage("Password is not defined");
        }
        if (!user.getUsername().equals("root") || !user.getPassword().equals("1234")) {
            return new ValidationMessage("Username or password is not correct");
        }
        return new ValidationMessage("ok");
    }
}
