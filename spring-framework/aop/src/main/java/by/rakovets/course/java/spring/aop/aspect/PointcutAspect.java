package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class PointcutAspect {
    @Pointcut("execution(public String getName())")
    public void getNamePointcut() {
    }

    @Pointcut("within(by.rakovets.course.java.spring.aop.service.*)")
    public void allMethodsPointcut() {
    }

    @Before("getNamePointcut()")
    public void advice2() {
        log.info("Advice: {}, Pointcut: {}, Order: {}", "`@Before`", "named `@Pointcut`", 2);
    }

    @Before("getNamePointcut()")
    public void advice1() {
        log.info("Advice: {}, Pointcut: {}, Order: {}", "`@Before`", "named `@Pointcut`", 1);
    }

    @Before("allMethodsPointcut()")
    public void allServiceMethodsAdvice() {
        log.info("Advice: {}, Pointcut: {}", "`@Before`", "named `@Pointcut`");
    }
}
