package ru.pelse.syntax.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationPlusReflection {
    public static void main(String[] args) {
        secondTask(User.class);
    }
        // 2. если класс аннотирован аннотацией ConfigClass,
        // создать объект данного класса (использовать рефлексию!)
        // если поле отмечено аннотацией @Required - установить значение
        // данного поля (значение любое!)
        // значение поля установить через сеттер!!!
        // stringData / setStringData
        // field.getName()
        // field.getType()
        // у созданного объекта вызвать метод public String toString(),
        // используя рефлексию
    public static void secondTask(Class<?> cls) {
        Annotation[] annotations = cls.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        System.out.println(cls.getName()); //посмотрели, что за класс
        User userClass = null;
        Constructor[] declaredConstructors;
        Constructor<User> userConstructor = null;
        if (cls.isAnnotationPresent(ConfigClass.class)) {
            declaredConstructors = cls.getDeclaredConstructors();
            System.out.println(Arrays.toString(declaredConstructors));//узнали что есть пустой к-р
            try {
                userConstructor = (Constructor<User>) cls.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                assert userConstructor != null;
                userClass = userConstructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("потенциально созданный объект: " + userClass);

        Field[] fields = getClassFields(cls);
        for (Field field : fields) {
            //проверить наличие аннотаций
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println("поле с аннотацией Required: " + field);
                Method declaredMethod;
                Class<?>[] paramTypes;
                Object  [] args;
                try {
                    if (userClass != null) {
                        String fieldName = firstUpperCase(field.getName());
                        paramTypes = new Class[] {int.class};
                        declaredMethod = cls.getDeclaredMethod("set".concat(fieldName), paramTypes);
                        System.out.println("получили метод: " + declaredMethod);
                        args = new Object[]{100};
                        try {
                            declaredMethod.invoke(userClass, args);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        assert userClass != null;
        System.out.println("Значение age установлено через рефлексию: \n" + userClass.toString());
        Method[] methods = getClassMethods(cls);
        for (Method method : methods) {
            if (method.isAnnotationPresent(Required.class)) {
                System.out.println("метод с аннотацией Required: " + method);
            }
        }


    }

    private static Field[] getClassFields(Class<?> cls)
    {
        Field[] fields = cls.getDeclaredFields();
        System.out.println("Class fields");
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("Class name : " + field.getName());
            System.out.println("Class type : " + fld.getName());
        }
        return fields;
    }

    private static Method[] getClassMethods(Class<?> cls)
    {
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Class methods");
        for (Method method : methods) {
            System.out.println("Method name : " + method.getName());
            System.out.println("Return type : " +
                    method.getReturnType().getName());
            Class<?>[] params = method.getParameterTypes();
            System.out.print("Parameters : ");
            for (Class<?> param : params)
                System.out.print(" " + param.getName());
            System.out.println();
        }
        return methods;
    }

    static public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
