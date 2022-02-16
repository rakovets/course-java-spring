package by.rakovets.course.java.spring.webmvc.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
