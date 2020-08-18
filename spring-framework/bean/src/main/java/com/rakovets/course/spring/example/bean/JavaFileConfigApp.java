package com.rakovets.course.spring.example.bean;

import com.rakovets.course.spring.example.bean.project.Config;
import com.rakovets.course.spring.example.bean.project.service.HeroService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaFileConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}
