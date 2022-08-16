package by.rakovets.course.java.spring.boot.web_service.controller;

import by.rakovets.course.java.spring.boot.web_service.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    private final PetRepository petRepository;

    @Autowired
    public ProfileController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("profile/{id}")
    public String profile(@PathVariable String id, Model model) {
        model.addAttribute("pet", petRepository.getPetById(Long.parseLong(id)));
        return "pet";
    }
}
