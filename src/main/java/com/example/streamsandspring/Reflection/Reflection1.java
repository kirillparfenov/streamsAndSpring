package com.example.streamsandspring.Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
Служебный класс, экземпляры которого (Java классы) хранят конкретную информацию о конкретном классе.
* */
public class Reflection1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        MyClass obj = new MyClass();

        //Способы получения объекта типа Class:
        Class c1 = MyClass.class;

        Class c2 = obj.getClass();

        Class c3 = Class.forName("Reflection.MyClass");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
        //Способы получения информации о внутренних методах через Method[]
        // .getMethods
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("Метод: " + method.getName() + " // "
                    + method.getReturnType() + " // "
                    + Arrays.toString(method.getParameterTypes()));
            System.out.println("--------------------------");
        }


        //Способы получения полей через Field[]
        // .getFields() - будут возвращены public поля
        // .getDeclaredFields() - вернет и public и private поля (это используется в Spring для аннотации @Autowired)
        Field[] fieldsPublic = c1.getFields();
        for (Field field : fieldsPublic) {
            System.out.println("Публичное поле: " + field.getName() + " // " + field.getType());
            System.out.println("--------------------------");
        }

        Field[] fieldsPrivateAndPublic = c1.getDeclaredFields();
        for (Field field : fieldsPrivateAndPublic) {
            System.out.println("Приватное или публичное поле: " + field.getName() + " // " + field.getType());
            System.out.println("--------------------------");
        }


        //Проверка, что в нашем классе есть аннотации с помощью Annotation[]
        // .getAnnotations()
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes");
                System.out.println("--------------------------");
            }
        }
    }
}
