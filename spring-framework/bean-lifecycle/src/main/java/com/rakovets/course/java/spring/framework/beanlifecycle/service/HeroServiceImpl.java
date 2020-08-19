package com.rakovets.course.java.spring.framework.beanlifecycle.service;

import com.rakovets.course.java.spring.framework.beanlifecycle.annotation.InjectRandomGreeting;
import com.rakovets.course.java.spring.framework.beanlifecycle.annotation.InjectRandomInt;
import com.rakovets.course.java.spring.framework.beanlifecycle.annotation.Language;
import com.rakovets.course.java.spring.framework.beanlifecycle.annotation.Profiling;
import com.rakovets.course.java.spring.framework.beanlifecycle.dao.HeroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profiling
public class HeroServiceImpl implements HeroService {
    @InjectRandomInt(min = 5, max = 10)
    private int number;

    @InjectRandomGreeting(language = Language.EN)
    private String greeting;

    private HeroDao heroDao;

    public HeroServiceImpl() {
        System.out.println("HeroService конструктор вызван");
        logData();
    }

    @Override
    public void printHeroNameById(Long id) {
        String name = heroDao.getNameById(id);
        System.out.println(name);
    }

    @PostConstruct
    public void init() {
        System.out.println("HeroService инициализируется через @PostConstruct");
        logData();
        System.out.println(greeting);
    }

    @Autowired
    public void setHeroDao(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    private void logData() {
        System.out.println(number);
        for (int i = 0; i < number; i++) {
            System.out.println("Логирую данные");
        }
    }
}
