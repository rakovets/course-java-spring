package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Связывание advice с помощью аннотации.
 */
@Slf4j
@Aspect
public class AnnotationAspect {
    @Before("@annotation(by.rakovets.course.java.spring.aop.aspect.Loggable)")
    public void myAdvice() {
        log.info("Advice: {}, Pointcut: {},", "`@Before`", "`@annotation()`");
    }
}
