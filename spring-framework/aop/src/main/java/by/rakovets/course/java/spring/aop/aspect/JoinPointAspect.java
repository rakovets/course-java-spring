package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Slf4j
@Aspect
public class JoinPointAspect {
    @Before("execution(public void by.rakovets.course.java.spring.aop.model..set*(*))")
    public void loggingAdvice(JoinPoint joinPoint) {
        log.info("Advice: {}, Pointcut: {}", "`@Before`", "execution()`");
        log.debug("JoinPoint: {}", joinPoint);
    }

    @Before("args(name)")
    public void logStringArguments(String name) {
        log.info("Advice: {}, Pointcut: {}", "`@Before`", "args()");
        log.debug("arg 'name' = {}", name);
    }
}
