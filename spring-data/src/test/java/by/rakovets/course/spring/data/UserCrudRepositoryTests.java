package by.rakovets.course.spring.data;

import by.rakovets.course.spring.data.entity.User;
import by.rakovets.course.spring.data.repository.UserCrudRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/application-context.xml"})
public class UserCrudRepositoryTests {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @BeforeEach
    public void init() {
        userCrudRepository.save(new User(1L, "Mat", "White", 21));
        userCrudRepository.save(new User(2L, "Tom", "Black", 33));
        userCrudRepository.save(new User(null, "Jin", "Smith", 22));
        userCrudRepository.save(new User(null, "Alex", "Bush", 31));
        userCrudRepository.save(new User(null, "Greg", "Cook", 26));
        userCrudRepository.save(new User(null, "Jhon", "Grey", 72));
    }

    @Test
    public void crudRepositoryTest() {
        System.out.println(userCrudRepository.existsById(1L));
        User user = userCrudRepository.findById(1L).orElseGet(null);
        System.out.println(user);
        user.setAge(22);
        userCrudRepository.save(user);
        System.out.println(user);
        user = userCrudRepository.findAll().iterator().next();
        userCrudRepository.delete(user);
        System.out.println(userCrudRepository.existsById(user.getId()));
    }

    @Test
    public void queryMethodTest() {
        userCrudRepository.findByFirstName("Mat").forEach(System.out::println);
        userCrudRepository.findByAgeBetweenAndFirstNameEndingWith(20, 30, "n").forEach(System.out::println);
        userCrudRepository.findByOrderByFirstNameDesc().forEach(System.out::println);
    }
}
