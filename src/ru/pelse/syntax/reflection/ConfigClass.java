package ru.pelse.syntax.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //это для классов (TYPE, нет константы CLASS)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigClass {
    //доп инфо аннотации: можно использовать только строки, примитивы и enum
    String prefix();
    Gender gender = null;
    long version() default 1;

    Gender gender();
}
