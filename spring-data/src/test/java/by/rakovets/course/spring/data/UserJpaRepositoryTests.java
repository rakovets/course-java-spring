package by.rakovets.course.spring.data;

import by.rakovets.course.spring.data.entity.User;
import by.rakovets.course.spring.data.repository.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/application-context.xml"})
public class UserJpaRepositoryTests {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @BeforeEach
    public void init() {
        userJpaRepository.save(new User(null, "Mat", "White", 21));
        userJpaRepository.save(new User(null, "Tom", "Black", 33));
        userJpaRepository.save(new User(null, "Jin", "Smith", 42));
        userJpaRepository.save(new User(null, "Alex", "Bush", 31));
        userJpaRepository.save(new User(null, "Greg", "Cook", 26));
        userJpaRepository.save(new User(null, "Jhon", "Grey", 72));
    }

    @Test
    public void jpaRepositoryTest() {
        System.out.println(userJpaRepository.existsById(1L));
        User user = userJpaRepository.getById(1L);
        System.out.println(user);
        user.setFirstName("New name " + user.getFirstName());
        userJpaRepository.saveAndFlush(user);
        User newUser = userJpaRepository.getById(1L);
        System.out.println(newUser);
    }
}
