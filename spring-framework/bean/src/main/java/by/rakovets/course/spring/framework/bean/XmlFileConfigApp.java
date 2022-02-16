package by.rakovets.course.spring.framework.bean;

import by.rakovets.course.spring.framework.bean.knights.BraveKnight;
import by.rakovets.course.spring.framework.bean.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlFileConfigApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application-context.xml");
        Knight knight = context.getBean(BraveKnight.class);
        knight.embarkOnQuest();
    }
}
