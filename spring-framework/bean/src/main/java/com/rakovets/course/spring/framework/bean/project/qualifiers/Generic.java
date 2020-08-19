package com.rakovets.course.spring.framework.bean.project.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.RUNTIME)
@Qualifier
public @interface Generic {
}
