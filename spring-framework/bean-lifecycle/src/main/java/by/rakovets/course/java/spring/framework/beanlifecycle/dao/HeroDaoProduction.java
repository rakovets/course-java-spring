package by.rakovets.course.java.spring.framework.beanlifecycle.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Profile("prod")
public class HeroDaoProduction implements HeroDao {
    @Override
    public String getNameById(Long id) {
        return "Production hero";
    }
}
