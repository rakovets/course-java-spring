package by.rakovets.course.java.spring.security.controller;

import by.rakovets.course.java.spring.security.dal.entity.Role;
import by.rakovets.course.java.spring.security.dto.UserRegistrationRequest;
import by.rakovets.course.java.spring.security.exception.UserExistException;
import by.rakovets.course.java.spring.security.service.AccountService;
import by.rakovets.course.java.spring.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    private final RoleService roleService;
    private final AccountService accountService;

    @Autowired
    public AuthController(RoleService roleService, AccountService accountService) {
        this.roleService = roleService;
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationView(Model model) {
        List<Role> all = roleService.getAll();
        model.addAttribute("roles", all);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(UserRegistrationRequest userRegistrationRequest) throws UserExistException {
        accountService.createUser(userRegistrationRequest);
        return "redirect:login";
    }
}
