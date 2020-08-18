package com.rakovets.course.java.spring.orm;

import com.rakovets.course.java.spring.orm.dal.entity.Knight;
import com.rakovets.course.java.spring.orm.service.KnightService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringOrmApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application-context.xml");

        KnightService service = context.getBean(KnightService.class);
        Knight knight = new Knight();
        knight.setName("Arthur");
        service.save(knight);
        Knight found = service.findByName("Arthur");
        System.out.println(found);
    }
}
