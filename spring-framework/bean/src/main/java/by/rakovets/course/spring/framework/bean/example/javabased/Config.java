package by.rakovets.course.spring.framework.bean.example.javabased;

import by.rakovets.course.spring.framework.bean.example.javabased.dao.HeroDao;
import by.rakovets.course.spring.framework.bean.example.javabased.service.HeroService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class Config {
    @Bean
    public String someString() {
        return "Hello";
    }

    @Bean
    public HeroService heroService(@Qualifier("heroDaoImplImproved") HeroDao heroDao, String someString) {
        return new HeroService(heroDao, someString);
    }
}
