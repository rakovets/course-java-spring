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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userDao.findByName(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("Can't find user by provided name!");
        }
        return new org.springframework.security.core.userdetails.User(foundUser.getName(),
                foundUser.getPassword(), getUserAuthorities(foundUser));
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<Role> roles = user.getRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;

//        return systemUser.getRoles()
//                .stream()
//                .map(r -> new SimpleGrantedAuthority(r.getName()))
//                .collect(Collectors.toSet());
    }
}
