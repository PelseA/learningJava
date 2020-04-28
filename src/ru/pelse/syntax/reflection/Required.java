package ru.pelse.syntax.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//указание для чего используется, например, методы и поля
@Target({ElementType.METHOD, ElementType.FIELD})
//когда будем использовать, например, в момент выполнения программы
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
}