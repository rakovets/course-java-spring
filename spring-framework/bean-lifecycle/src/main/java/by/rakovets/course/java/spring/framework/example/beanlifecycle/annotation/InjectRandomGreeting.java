package by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation;

import by.rakovets.course.java.spring.framework.example.beanlifecycle.model.Language;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectRandomGreeting {
    Language language();
}
