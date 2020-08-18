package com.rakovets.course.java.spring.example.beanlifecycle.processor;

import com.rakovets.course.java.spring.example.beanlifecycle.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;


public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectRandomInt.class)) {
                Random random = new Random();
                InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                int randomNumber = min + random.nextInt(max - min + 1);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, randomNumber);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
