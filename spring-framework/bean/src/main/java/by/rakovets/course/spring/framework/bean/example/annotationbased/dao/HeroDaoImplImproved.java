package by.rakovets.course.spring.framework.bean.example.annotationbased.dao;

import by.rakovets.course.spring.framework.bean.example.annotationbased.qualifiers.Improved;
import org.springframework.stereotype.Repository;


@Repository
@Improved
public class HeroDaoImplImproved implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Improved dao result";
    }
}
