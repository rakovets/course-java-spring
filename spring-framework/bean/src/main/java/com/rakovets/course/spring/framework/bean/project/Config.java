package com.rakovets.course.spring.framework.bean.project;

import com.rakovets.course.spring.framework.bean.project.dao.HeroDao;
import com.rakovets.course.spring.framework.bean.project.dao.HeroDaoImplGeneric;
import com.rakovets.course.spring.framework.bean.project.service.HeroService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"by.hector.project"})
public class Config {
    @Bean
    public String someString() {
        return "Hello";
    }

    @Bean
    public HeroDao heroDao() {
        return new HeroDaoImplGeneric();
    }

    @Bean
    public HeroService heroService(HeroDao heroDao, String someString) {
        return new HeroService(heroDao, someString);
    }
}
