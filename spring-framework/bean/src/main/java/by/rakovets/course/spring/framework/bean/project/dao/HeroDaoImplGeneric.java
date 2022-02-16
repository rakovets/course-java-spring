package by.rakovets.course.spring.framework.bean.project.dao;

import by.rakovets.course.spring.framework.bean.project.qualifiers.Generic;
import org.springframework.stereotype.Repository;


@Repository
@Generic
public class HeroDaoImplGeneric implements HeroDao {
    public String getNameById(Long id) {
        return "Generic dao result";
    }
}
