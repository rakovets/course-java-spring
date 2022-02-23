package by.rakovets.course.java.spring.framework.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Properties;


@Repository
@Profile("prod")
public class UserDaoProd implements UserDao {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String getNameById(Long id) {
        System.out.println(url);
        System.out.println(password);
        System.out.println(this.getClass().getSimpleName());
        return this.getClass().getSimpleName();
    }
}
