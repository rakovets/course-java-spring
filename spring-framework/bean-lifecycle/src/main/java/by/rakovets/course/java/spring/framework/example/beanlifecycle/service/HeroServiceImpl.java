package by.rakovets.course.java.spring.framework.example.beanlifecycle.service;

import by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation.InjectRandomGreeting;
import by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation.InjectRandomInt;
import by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation.Profiling;
import by.rakovets.course.java.spring.framework.example.beanlifecycle.dao.HeroDao;
import by.rakovets.course.java.spring.framework.example.beanlifecycle.model.Language;
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
            System.out.println("Custom logic");
        }
    }
}
