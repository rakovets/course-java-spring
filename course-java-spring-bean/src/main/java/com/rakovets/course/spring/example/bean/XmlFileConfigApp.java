package com.rakovets.course.spring.example.bean;

import com.rakovets.course.spring.example.bean.knights.BraveKnight;
import com.rakovets.course.spring.example.bean.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlFileConfigApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application-context.xml");
        Knight knight = context.getBean(BraveKnight.class);
        knight.embarkOnQuest();
    }
}
