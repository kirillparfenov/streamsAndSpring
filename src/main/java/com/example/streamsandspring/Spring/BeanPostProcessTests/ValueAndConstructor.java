package com.example.streamsandspring.Spring.BeanPostProcessTests;

import Spring.BeanPostProcessTests.test2.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*
Получим ли мы в конструкторе значение из @Value("${my.value}")?

Ответ: Нет.
Причина:
1) Сначала Spring создает объекты из BeanDefinition, т.е. что это значит:
    - Происходит инициализация статических полей и блоков, анонимных блоков и НЕстатических полей, а также конструкторов бинов.
2) Затем Spring переходит к BeanPostProcessor и начинает настраивать бины через методы:
    - postProcessBeforeInitialization()
    - вызов @PostConstruct (если эта аннотация присутствует в коде)
    - postProcessAfterInitialization()

Значение @Value подтянется после отработки метода BeanPostProcesso.postProcessBeforeInitialization().
Т.е. мы можем использовать @PostConstruct, чтобы прочитать значение из @Value
 */
@Component
@PropertySource("classpath:application.properties")
public class ValueAndConstructor {

    @Value("${hello.world}")
    private String helloWorld;

    private String goodByeWorld = "goodBye world";

    @Autowired
    private Client client;

    public ValueAndConstructor() {
        System.out.println(helloWorld); //При обычном старте выведет null
        System.out.println(goodByeWorld); //При обычном старте выведет значение этой переменной
        System.out.println(client + " - constructor client!"); //выведет null, также как и @Value
        System.out.println("=====================================");
    }

    @PostConstruct
    private void initMethod() {
        System.out.println(helloWorld); //здесь уже выведет значение @Value
        System.out.println(client + " - @PostConstruct client!"); //выведет объект Client
        System.out.println("=====================================");
    }
}
