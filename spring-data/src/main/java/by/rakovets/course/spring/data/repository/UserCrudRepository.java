package by.rakovets.course.spring.data.repository;

import by.rakovets.course.spring.data.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    List<User> findByAgeBetweenAndFirstNameEndingWith(int startAge, int endAge, String endingName);

    List<User> findByOrderByFirstNameDesc();

    List<User> findByFirstNameInAndAgeIn(List<String> firstnames, List<Integer> ages);
}
