package com.rakovets.course.java.spring.restfulwebservices.controller;

import com.rakovets.course.java.spring.restfulwebservices.dto.Animation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("animation")
public class TestRestController {
    @GetMapping
    public Animation loadSampleAnimation() {
        return new Animation(1L, "Бременские музыканты", LocalDate.now());
    }

    @PostMapping
    public ResponseEntity<Animation> saveAnimation(@RequestBody Animation animation) {
        System.out.println(animation);
        return ResponseEntity.ok().build();
    }

    @GetMapping("load")
    public ResponseEntity<Animation> loadAnimation() {
        return ResponseEntity.ok(
                new Animation(1L, "Бременские музыканты", LocalDate.now()));
    }
}
