package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AroundAspect {
    /**
     * Помеченный аннотацией @Around метод как бы «оборачивает» вызов метода
     * целевого класса. Данная аннотация является наиболее мощным средством для
     * создания аспектов, но при этом такой подход требует наибольших
     * трудозатрат.
     */
    @Around("execution(* by.rakovets.course.java.spring.aop.model.Employee.getName())")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Advice: {}, Pointcut: {}", "Around", "specify method `getName()`");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Advice: {}, Pointcut: {}", "Around", "specify method `getName()`");
        return value;
    }
}
