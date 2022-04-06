package by.rakovets.course.java.spring.aop.examples;

import by.rakovets.course.java.spring.aop.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Example3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

        log.info("Before executing: throwException()");
        employeeService.getEmployee().throwException();
        log.info("After executing: throwException()");

        ctx.close();
    }
}
