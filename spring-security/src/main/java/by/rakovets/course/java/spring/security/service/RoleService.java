package by.rakovets.course.java.spring.security.service;

import by.rakovets.course.java.spring.security.dal.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<String> getRoles(Collection<? extends GrantedAuthority> grantedAuthorities);

    List<Role> getAll();
}
