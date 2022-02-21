package by.rakovets.course.spring.framework.bean.example.xmlbased;

import by.rakovets.course.spring.framework.bean.example.xmlbased.model.impl.BraveKnight;
import by.rakovets.course.spring.framework.bean.example.xmlbased.model.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlFileConfigApp {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("xml-application-context.xml");
        Knight knight = context.getBean(BraveKnight.class);
        knight.embarkOnQuest();
    }
}
