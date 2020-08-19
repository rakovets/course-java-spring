package com.rakovets.course.spring.framework.bean.project.service;

import com.rakovets.course.spring.framework.bean.project.dao.HeroDao;
import com.rakovets.course.spring.framework.bean.project.qualifiers.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HeroService {
    private HeroDao heroDao;
    private String name;

    @Autowired
    public HeroService(@Generic HeroDao heroDao, String name) {
        this.heroDao = heroDao;
        this.name = name;
    }

    public void printHeroNameById(Long id) {
        System.out.println(name);
        String name = heroDao.getNameById(id);
        System.out.println(name);
    }
}
