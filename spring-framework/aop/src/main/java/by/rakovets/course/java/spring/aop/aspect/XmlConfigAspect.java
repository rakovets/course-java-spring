package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class XmlConfigAspect {
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Advice: {}, Pointcut: {}", "Around", "`<aop:pointcut/>`");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("Advice: {}, Pointcut: {}", "Around", "`<aop:pointcut/>`");
        value = value + "24";
        return value;
    }
}
