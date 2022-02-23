package by.rakovets.course.spring.framework.bean.example.annotationbased.service;

import by.rakovets.course.spring.framework.bean.example.annotationbased.dao.HeroDao;
import org.springframework.stereotype.Service;


@Service
public class QuestService {
    private HeroDao heroDao;

    public void getQuest() {
        heroDao.getNameById(1L);
    }

    public void setHeroDao(HeroDao heroDao) {
        this.heroDao = heroDao;
    }
}
