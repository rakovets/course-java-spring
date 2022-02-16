package by.rakovets.course.java.spring.security.dal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class SystemUser extends BaseEntity {
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany
    @Getter
    @Setter
    private Set<Role> roles = new HashSet<>();
}
