package by.rakovets.course.java.spring.security.service;

import by.rakovets.course.java.spring.security.dto.UserRegistrationRequest;
import by.rakovets.course.java.spring.security.exception.UserExistException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService {
    void createUser(UserRegistrationRequest userRegistrationRequest) throws UserExistException;
}
