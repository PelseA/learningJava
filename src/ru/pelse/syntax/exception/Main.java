package ru.pelse.syntax.exception;

import ru.pelse.syntax.exception.status.Status;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) {
        //task 2
        Object[] exceptionsList = new Object[9];
        try {
            int[] arr = new int[5];
            arr[7] = 12;
        } catch (ArrayIndexOutOfBoundsException e) {
            addExceptionToList(exceptionsList, e);
        }

        int res;
        int a = 75;
        int b = 0;
//        try {
//            res = a / b;
//        } catch (ArithmeticException e) {
//            res = 0;
//            try {
//                addExceptionToList(exceptionsList, e.toString());
//            } catch (ArrayStoreException ex) {
//                addExceptionToList(exceptionsList, ex);
//            }
//        }

        Integer num;
//        try {
//            int num1 = num.intValue();
//        } catch (NullPointerException e) {
//            addExceptionToList(exceptionsList, e);
//            num = new Integer(10);
//        }
//
//        Object ch = new Character('*');
//        try
//        {
//            Byte bt = (Byte)ch;
//        }
//        catch(ClassCastException e)
//        {
//            addExceptionToList(exceptionsList, e);
//        }

        try
        {
            int[] nNegArray = new int[-5];
        }
        catch(NegativeArraySizeException e)
        {
            addExceptionToList(exceptionsList, e);
        }

        String shortString = "123";
        try
        {
            char chr = shortString.charAt(10);
        }
        catch(StringIndexOutOfBoundsException e)
        {
            addExceptionToList(exceptionsList, e);
        }

    }

    static void addExceptionToList(Object[] exceptionsList, Exception e) {
        for (int i = 0; i < exceptionsList.length; i++) {
            if(exceptionsList[i] == null) {
                exceptionsList[i] = e;
                break;
            }
        }
    }

    static void throwMyException(Status status, String file) throws JarException, FileNotFoundException,
            AccessDeniedException {
        IOException exception;
        switch (status) {
            case FILE_NOT_FOUND:
                exception = new FileNotFoundException();
                System.out.println(exception.getMessage() + " проверьте path и все слеши");
                throw new FileNotFoundException();
            case ACCESS_DENIED:
                // Если выбросить до sout то уже не получится вывести sout после
                // в задании написано "AccessDeniedException - выводить в консоль
                // сообщение исключения (метод getMessage()) и снова выбрасывать exception,"
                // у меня так не получается
                exception = new AccessDeniedException(file);
                System.out.println(exception.getMessage());
                throw new AccessDeniedException(file);
            case JAR_ERROR:
                // тут вопрос: это исключение лежит в zip - оно есть в java 8? Я это не поняла.
                exception = new JarException();
                exception.printStackTrace();
                throw new JarException();
        }
    }
}
