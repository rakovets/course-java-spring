package by.rakovets.course.spring.framework.bean.example.annotationbased;

import by.rakovets.course.spring.framework.bean.example.annotationbased.service.HeroService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlFileAnnotationConfigApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation-application-context.xml");
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}
