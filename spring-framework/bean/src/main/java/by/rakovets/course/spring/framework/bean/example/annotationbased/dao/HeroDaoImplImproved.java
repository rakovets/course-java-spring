package by.rakovets.course.spring.framework.bean.example.annotationbased.dao;

import org.springframework.stereotype.Repository;


@Repository
public class HeroDaoImplImproved implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Improved dao result";
    }
}
