package com.rakovets.course.java.spring.security.service;

import com.rakovets.course.java.spring.security.dal.dao.UserDao;
import com.rakovets.course.java.spring.security.dal.entity.Role;
import com.rakovets.course.java.spring.security.dal.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser foundSystemUser = userDao.findByName(username);
        if (foundSystemUser == null) {
            throw new UsernameNotFoundException("Can't find user by provided name!");
        }
        return new User(foundSystemUser.getName(),
                foundSystemUser.getPassword(), getUserAuthorities(foundSystemUser));
    }

    private Set<GrantedAuthority> getUserAuthorities(SystemUser systemUser) {
        Set<Role> roles = systemUser.getRoles();
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
