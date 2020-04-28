package ru.pelse.syntax.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User("hhj", 66);
        try {
            toString(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // 1. написать рефлексивный статический static toString(Object o)
    // вывести информацию по полям объекта, используя рефлексию:
    // название поля: значение поля
    static void toString(Object o) throws ClassNotFoundException {
        //получим ссылки на класс через объект
        String[] consist = String.valueOf(o.getClass()).split("\\.");
        String className = consist[consist.length - 1];
        System.out.println("пришел объект класса " + className);
        String[] classInfo = String.valueOf(o.getClass()).split(" ");
        String classPackage = classInfo[classInfo.length - 1];
        Class someClass = Class.forName(classPackage);
        System.out.println(someClass);
        //посмотрим на конструкторы
        Constructor[] declaredConstructors = someClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            Class<?>[] params = constructor.getParameterTypes();
            for (Class<?> param : params) {
                System.out.println(param.getName());
            }
        }
        //узнали, что у класса User есть конструктор (String.class, int.class)
        Constructor<User> userConstructor = null;
        try {
            userConstructor = someClass.getDeclaredConstructor(String.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //создадим объект User с помощью рефлексии
        User reflectUser = null;
        try {
            assert userConstructor != null;
            reflectUser = userConstructor.newInstance("login is set using reflection", 43);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //нам неизвестны поля класса пришедшего объекта
        //узнаем, сколько и какие поля у класса, их модификаторы
        Field[] fields = someClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        //узнали, что там String login и int age

        Field fieldLogin = null;
        Field fieldAge = null;
        try {
            fieldLogin = someClass.getDeclaredField("login");
            fieldAge = someClass.getDeclaredField("age");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        assert fieldLogin != null;
        fieldLogin.setAccessible(true);
        assert fieldAge != null;
        fieldAge.setAccessible(true);

        try {
            fieldLogin.set(reflectUser, "Антонио");
            fieldAge.set(reflectUser, 36);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String login;
        int age;

        //вывод в консоль по первой задаче
        try {
            login = (String) fieldLogin.get(reflectUser);
            age = (int) fieldAge.get(reflectUser);
            System.out.println(fieldLogin + " : " + login);
            System.out.println(fieldAge + " : " + age);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}

