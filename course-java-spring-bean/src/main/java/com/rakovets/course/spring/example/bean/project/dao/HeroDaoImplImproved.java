package com.rakovets.course.spring.example.bean.project.dao;

import com.rakovets.course.spring.example.bean.project.qualifiers.Improved;
import org.springframework.stereotype.Repository;


@Repository
@Improved
public class HeroDaoImplImproved implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Improved dao result";
    }
}
