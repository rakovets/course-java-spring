package by.rakovets.course.spring.data.repository;

import by.rakovets.course.spring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
