package by.rakovets.course.java.spring.security.service;

import by.rakovets.course.java.spring.security.dal.dao.RoleDao;
import by.rakovets.course.java.spring.security.dal.dao.UserDao;
import by.rakovets.course.java.spring.security.dal.entity.Role;
import by.rakovets.course.java.spring.security.dal.entity.User;
import by.rakovets.course.java.spring.security.dto.UserRegistrationRequest;
import by.rakovets.course.java.spring.security.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserRegistrationRequest userRegistrationRequest) throws UserExistException {
        User byName = userDao.findByName(userRegistrationRequest.getUsername());
        if (byName != null) {
            throw new UserExistException(String.format("User with username %s is exist.", userRegistrationRequest.getUsername()));
        }
        Role role = roleDao.findOne(userRegistrationRequest.getRoleId());
        User user = new User();
        user.setName(userRegistrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        user.setRoles(Set.of(role));
        userDao.save(user);
    }
}
