package by.rakovets.course.java.spring.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String password;
    private Long roleId;
}
