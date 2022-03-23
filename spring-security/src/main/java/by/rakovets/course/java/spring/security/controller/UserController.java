package by.rakovets.course.java.spring.security.controller;

import by.rakovets.course.java.spring.security.dto.UserInfoDto;
import by.rakovets.course.java.spring.security.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final RoleServiceImpl roleService;

    @Autowired
    public UserController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String showUserView(Authentication authentication, Model model) {
        List<String> roles = roleService.getRoles(authentication.getAuthorities());
        model.addAttribute("userInfo", new UserInfoDto(authentication.getName(), roles));
        return "user";
    }
}
