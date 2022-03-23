package by.rakovets.course.java.spring.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDto {
    private String username;
    private List<String> roles;
}
