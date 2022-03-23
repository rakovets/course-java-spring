package by.rakovets.course.java.spring.security.dal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @JoinTable(name = "user_role_link",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
