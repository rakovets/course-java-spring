package by.rakovets.course.java.spring.framework.example.beanlifecycle.dao;

import org.springframework.stereotype.Repository;


@Repository
public class HeroDaoImpl implements HeroDao {
    @Override
    public String getNameById(Long id) {
        System.out.println(this.getClass().getSimpleName());
        return this.getClass().getSimpleName();
    }
}
