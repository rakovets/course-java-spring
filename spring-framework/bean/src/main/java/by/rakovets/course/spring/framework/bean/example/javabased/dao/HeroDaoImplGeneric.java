package by.rakovets.course.spring.framework.bean.example.javabased.dao;

import org.springframework.stereotype.Repository;


@Repository
public class HeroDaoImplGeneric implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Generic dao result";
    }
}
