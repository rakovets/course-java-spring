package by.rakovets.course.java.spring.aop.examples;

import by.rakovets.course.java.spring.aop.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Example1 {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

        log.info("Before executing: getName()");
        String name = employeeService.getEmployee().getName();
        log.info("After executing: getName()");

        ctx.close();
    }
}
