package com.rakovets.course.spring.example.bean.project.service;

import com.rakovets.course.spring.example.bean.project.dao.HeroDao;
import com.rakovets.course.spring.example.bean.project.qualifiers.Generic;
import org.springframework.stereotype.Service;


@Service
public class QuestService {
    private HeroDao heroDao;

    public void getQuest() {
        heroDao.getNameById(1L);
    }

    public void setHeroDao(@Generic HeroDao heroDao) {
        this.heroDao = heroDao;
    }
}
