package by.rakovets.course.spring.framework.bean.example.annotationbased.dao;

import by.rakovets.course.spring.framework.bean.example.annotationbased.qualifiers.Generic;
import org.springframework.stereotype.Repository;


@Repository
@Generic
public class HeroDaoImplGeneric implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Generic dao result";
    }
}
