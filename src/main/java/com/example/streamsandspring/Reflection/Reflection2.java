package com.example.streamsandspring.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//Вызовем метод setName(String name) у объекта типа MyClass
//1. Создать объект типа MyClass
//2. Создать объект типа java.lang.String
//3. Указать метод setName
public class Reflection2 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {

        /*
        Создавать новые объекты класса (по умолчанию вызывается пустой конструктор)
         .newInstance()

        Получать методы по сигнатуре - передает название метода и набор типов параметров:
         .getMethod("indexOf", String.class, int.class) - метод String.indexOf()
        Вызвать метод - .invoke()
        Class string = String.class;
        Method method = string.getMethod("indexOf", String.class, int.class);


        Получать конструктор по сигнатуре
        .getConstructor()
        */

        Scanner scanner = new Scanner(System.in);

        //Класс типа Reflection.MyClass,
        Class c1 = Class.forName(scanner.next());
        // Класс типа java.lang.String,
        Class c2 = Class.forName(scanner.next());
        // имя метода setName
        String method = scanner.next();

        //Создаем метод setName
        Method m = c1.getMethod(method, c2);

        //Создаем объект типа Reflection.MyClass
        Object o1 = c1.getConstructor().newInstance();

        //Создаем объект типа java.lang.String
        Object o2 = c2.getConstructor(String.class).newInstance("Tom");

        //Вызываем метод setName(String name)
        m.invoke(o1, o2);

        System.out.println(o1);

    }
}
