package by.rakovets.course.java.spring.framework.example.beanlifecycle;

import by.rakovets.course.java.spring.framework.example.beanlifecycle.service.HeroService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifecycleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("application-context.xml");
        context.refresh();
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}
