package com.rakovets.course.java.spring.restfulwebservices.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
