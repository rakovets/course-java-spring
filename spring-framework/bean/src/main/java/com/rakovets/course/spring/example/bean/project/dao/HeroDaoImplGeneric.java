package com.rakovets.course.spring.example.bean.project.dao;

import com.rakovets.course.spring.example.bean.project.qualifiers.Generic;
import org.springframework.stereotype.Repository;


@Repository
@Generic
public class HeroDaoImplGeneric implements HeroDao {
    public String getNameById(Long id) {
        return "Generic dao result";
    }
}
