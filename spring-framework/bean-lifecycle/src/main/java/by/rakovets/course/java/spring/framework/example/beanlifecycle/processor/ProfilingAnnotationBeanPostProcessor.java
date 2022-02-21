package by.rakovets.course.java.spring.framework.example.beanlifecycle.processor;

import by.rakovets.course.java.spring.framework.example.beanlifecycle.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

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
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                        long startTime = System.nanoTime();
                        Object result = method.invoke(bean, args);
                        System.out.printf("Профилирую метод %s класса %s\n", method.getName(), beanClass.getSimpleName());
                        System.out.printf("Метод выполнялся %d наносекунд\n", System.nanoTime() - startTime);
                        return result;
                    });
        }
        return bean;
    }
}
