package by.rakovets.course.spring.framework.bean.example.annotationbased.service;

import by.rakovets.course.spring.framework.bean.example.annotationbased.dao.HeroDao;
import by.rakovets.course.spring.framework.bean.example.annotationbased.qualifiers.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HeroService {
    private final HeroDao heroDao;
    private final String name;

    @Autowired
    public HeroService(HeroDao heroDao, String name) {
        this.heroDao = heroDao;
        this.name = name;
    }

    public void printHeroNameById(Long id) {
        System.out.println(name);
        String name = heroDao.getNameById(id);
        System.out.println(name);
    }
}
