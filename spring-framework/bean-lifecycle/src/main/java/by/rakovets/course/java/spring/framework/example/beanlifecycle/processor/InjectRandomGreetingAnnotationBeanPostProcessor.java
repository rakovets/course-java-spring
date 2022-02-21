package by.rakovets.course.java.spring.framework.example.beanlifecycle.processor;

import by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation.InjectRandomGreeting;
import by.rakovets.course.java.spring.framework.example.beanlifecycle.model.Language;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class InjectRandomGreetingAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final List<String> enGreetings = Arrays.asList("Hello!", "Hi!", "Greetings!");
    private final List<String> ruGreetings = Arrays.asList("Привет!", "Здравствуй!", "Салют!");

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectRandomGreeting.class)) {
                InjectRandomGreeting annotation = declaredField.getAnnotation(InjectRandomGreeting.class);
                Language language = annotation.language();
                List<String> greetings = language == Language.RU ? ruGreetings : enGreetings;
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean,
                        greetings.get(new Random().nextInt(greetings.size())));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
