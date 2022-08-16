package by.rakovets.course.java.spring.boot.web_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private String age;
    private String color;
    private String breed;
    private String description;
}
