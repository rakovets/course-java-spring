package by.rakovets.course.java.spring.framework.example.properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile("dev")
public class UserDaoDev implements UserDao {
    @Override
    public String getNameById(Long id) {
        System.out.println(this.getClass().getSimpleName());
        return this.getClass().getSimpleName();
    }
}
