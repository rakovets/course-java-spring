package by.rakovets.course.spring.framework.bean.example.javabased;

import by.rakovets.course.spring.framework.bean.example.javabased.service.HeroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaFileConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}
