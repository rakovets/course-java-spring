package by.rakovets.course.java.spring.security.controller;

import by.rakovets.course.java.spring.security.dto.UserInfoDto;
import by.rakovets.course.java.spring.security.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String showAdminView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        List<String> roles = roleService.getRoles(authentication.getAuthorities());
        model.addAttribute("userInfo", new UserInfoDto(authentication.getName(), roles));
        return "admin";
    }
}
