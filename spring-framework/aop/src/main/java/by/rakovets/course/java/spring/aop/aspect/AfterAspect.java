package by.rakovets.course.java.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspect после выполнения методов
 */
@Slf4j
@Aspect
public class AfterAspect {
    /**
     * Использование аннотации @After можно сравнить с директивой finally языка
     * Java, то есть метод, помеченный этой аннотацией, будет выполнен
     * независимо от того, завершился ли метод целевого класса нормально или
     * исключительной ситуацией. Однако используя эту аннотацию, нет возможности
     * обращаться к возвращаемому значению целевой функции или к исключительной
     * ситуации, возникшей в ходе ее исполнения.
     *
     * @param name
     */
    @After("args(name)")
    public void logStringArguments(String name) {
        log.info("Advice: {}, Pointcut: {}", " @After", "args()`");
    }

    /**
     * Использование аннотации @AfterThrowing определяет, что сквозная
     * функциональность будет выполнена в том случае, если выполнение целевой
     * метода закончилось исключительной ситуацией. Тип исключения определяется
     * аргументом метода, помеченного этой аннотацией
     *
     * @param joinPoint
     */
    @AfterThrowing("within(by.rakovets.course.java.spring.aop.model.Employee)")
    public void logExceptions(JoinPoint joinPoint) {
        log.info("Advice: {}, Pointcut: {}", " @AfterThrowing", "within()`");
    }

    /**
     * Метод аспекта, помеченный аннотацией @AfterReturning, будет вызван после нормального завершения работы метода целевого класса. Под «нормальным
     * завершением» понимается, что в ходе выполнения не было сгенерировано исключительной ситуации (exception)
     *
     * @param returnString
     */
    @AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
    public void getNameReturningAdvice(String returnString) {
        log.info("Advice: {}, Pointcut: {}", " @AfterReturning", "execution()`");
    }
}
