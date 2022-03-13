package by.rakovets.course.java.spring.webmvc.view.controller;

import by.rakovets.course.java.spring.webmvc.view.dal.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Random;

@Controller
public class ModelInteractionController {
    @ModelAttribute
    public void addUserToModel(Model model) {
        User user = new User();
        user.setName("Dmitry");
        user.setPassword("2020327");
        model.addAttribute("user", user);
    }

    @ModelAttribute("user")
    public User addUserToModel() {
        User user = new User();
        user.setName("Dmitry");
        user.setPassword("2020327");
        return user;
    }

    @GetMapping(path = "/model")
    public String showModelPage(Model model /* Model */) {
        model.addAttribute("randomNumber", new Random().nextInt());
        return "user/model"; // View name
    }

    @PutMapping(path = "/model2")
    public String showModelPage2(Model model) {
        model.addAttribute("randomNumber", new Random().nextInt());
        return "user/model";
    }


}
