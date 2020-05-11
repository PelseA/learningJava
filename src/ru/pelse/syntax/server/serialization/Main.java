package ru.pelse.syntax.server.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);


        // передать объект в OutputStream / получить объект из InputStream
        // (сохранить состояние объектов в файл)
        // 1. преобразование в последовательность байт
        // сериализация - объект, как последовательность байт
        // десериализация - последовательность байт в объект (Object)
        // 2. запись в файл
        // 3. Класс должени реализовать интерфейс - маркер java.io.Serializable
        // (при этом есть возможность исключить поля из сериализации - transient)
        // или интерфейс java.io.Externalizable
        // (при этом есть возможность включить поля в сериализацию)

        // для десериализуемых объектов должен быть задан констуктор без параметров!

        // private static final long serialVersionUID - необходим, если описани класса
        // меняется после сериализации

        // java.io.Serializable:
        // если имплементация будет у дочернего класса,
        // то свойства, полученные от родителя не учавствут в сериализации / десериализации,
        // если имплементация будет у родительского класса,
        // то свойства, полученные от родителя учавствут в сериализации / десериализации
        // свойства отмеченные transient не участвуют в сериализации / десериализации

        // java.io.Externalizable:
        // только свойсва перечисленные в переопределяемых методах участвуют в сериализации / десериализации

        File file = new File("school.bin");
        System.out.println("ДО ЗАПИСИ " + pupil1);
        System.out.println("ДО ЗАПИСИ " + pupil2);
        System.out.println("ДО ЗАПИСИ " + director);

        objectToFile(file, pupil1);

        Pupil pupilFromFile1 = (Pupil) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + pupilFromFile1);
        System.out.println(pupil1.equals(pupilFromFile1));


        objectToFile(file, pupil2);

        Pupil pupilFromFile2 = (Pupil) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + pupilFromFile2);
        System.out.println(pupil2.equals(pupilFromFile2));

        objectToFile(file, director);

        Director directorFromFile = (Director) getObjectFromFile(file);
        System.out.println("ПОСЛЕ ЧТЕНИЯ " + directorFromFile);
        System.out.println(director.equals(directorFromFile));


    }

    private static void objectToFile(File file, Object obj){
        try (FileOutputStream fileOutput = new FileOutputStream(file);// запись в файл
            // сериализация
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            // OutputStream (file)  <---   objectOutput   <----- java app
            objectOutput.writeObject(obj);

        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
        } catch (IOException e) {
            System.out.println("Проблема с FileOutputStream");
        }
    }

    private static Object getObjectFromFile(File file){
        Object obj = null;
        // чтение из файла
        try (FileInputStream fileInput = new FileInputStream(file);
             // десериализация
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)
            ){
            // InputStream (file) ----> objectInput ------> java app
            obj = objectInput.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Файл file не найден");
        } catch (IOException e) {
            System.out.println("Проблема в момент чтения");
        } catch (ClassNotFoundException e) {
            System.out.println("readObject - Класс не найден");
        }

        return obj;
    }

}
