package com.rakovets.course.spring.example.bean;

import com.rakovets.course.spring.example.bean.project.service.HeroService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlFileAnnotationConfigApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation-application-context.xml");
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}
