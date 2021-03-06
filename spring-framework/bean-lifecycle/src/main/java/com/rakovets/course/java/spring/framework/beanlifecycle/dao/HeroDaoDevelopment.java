package com.rakovets.course.java.spring.framework.beanlifecycle.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile("dev")
public class HeroDaoDevelopment implements HeroDao {
    @Value("${jdbc.url}")
    private String url;

    @Override
    public String getNameById(Long id) {
        System.out.println(url);
        return "Development dao";
    }
}
