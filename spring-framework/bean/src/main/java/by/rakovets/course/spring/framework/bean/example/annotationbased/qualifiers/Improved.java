package by.rakovets.course.spring.framework.bean.example.annotationbased.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.RUNTIME)
@Qualifier
public @interface Improved {
}
