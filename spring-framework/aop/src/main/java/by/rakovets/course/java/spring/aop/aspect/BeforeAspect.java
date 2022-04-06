package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Метод аспекта, помеченный аннотацией @Before, будет вызван перед выполнением
 * метода целевого класса. В отличие от аннотации @Around, избежать вызова
 * метода целевого класса возможно только генерацией исключительной ситуации
 * (exception) внутри аспекта.
 */
@Slf4j
@Aspect
public class BeforeAspect {
    @Before("execution(public String getName())")
    public void getNameAdvice() {
        log.info("Advice: {}, Pointcut: {}", "`@Before`", "any public method `getName()`");
    }

    @Before("execution(* by.rakovets.course.java.spring.aop.service.*.get*())")
    public void getAllAdvice() {
        log.info("Advice: {}, Pointcut: {}", "`@Before`", "all method `get*` from specific package");
    }
}
