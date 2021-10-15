package com.example.streamsandspring.Spring.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Proxiez implements BeanPostProcessor {
    Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass(); //запоминаем класс бина, который пришел в этот метод, чтобы потом настроить для него Proxy
        map.put(beanName, beanClass);
        return bean;
    }

    /*
    вот тут вызывается @PostConstruct
     */

    //этот метод вызывается после инициализации данных в бине.
    //в этом методе мы можем обернуть наш бин в прокси.
    //Object invoke() - логика, которая будет добавляться в каждый вызываемый метод проксируемого бина.
    //method.invoke(bean, args) - вызов оригинального метода.
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName); //получаем из мапы класс бина, чтобы настроить Proxy
        Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (true) { //задаем условие для проксирования бина
                    System.out.println("Начало своей логики");
                    Object returnValue = method.invoke(bean, args); //вызов оригинального метода
                    System.out.println("Конец своей логики");
                    return returnValue;
                } else { //если условие не выполняется, то просто вызываем оригинальный метод
                    return method.invoke(bean, args);
                }
            }
        });
        return bean;
    }
}
