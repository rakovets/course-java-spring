package com.rakovets.course.java.spring.framework.beanlifecycle.processor;

import com.rakovets.course.java.spring.framework.beanlifecycle.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> beanMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            beanMap.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            long startTime = System.nanoTime();
                            Object result = method.invoke(bean, args);
                            System.out.println("Профилирую метод " + method.getName()
                                    + " класса " + beanClass.getSimpleName());
                            System.out.println("Метод выполнялся " + (System.nanoTime() - startTime) + " наносекунд");
                            return result;
                        }
                    });
        }
        return bean;
    }
}
