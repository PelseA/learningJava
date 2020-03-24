package ru.pelse.syntax.taskSchool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        Director director = new Director("Бороздин Альберт Викторович", 30);
        System.out.println(director.name);
        School school = new School("Test-school", director);

        //создание учителей
        Teacher teacher1 = new Teacher("Иван Алексеевич Приходько", 32, "математика");
        Teacher teacher2 = new Teacher("Апполон Станиславович Маков", 39, "черчение");
        Teacher teacher3 = new Teacher("Леонид Иванович Свидригайло", 41, "робототехника");
        Teacher teacher4 = new Teacher("Петр Петрович Макаревич", 29, "анатомия");
        Teacher teacher5 = new Teacher("Илона Викторовна Литвина", 20, "химия");
        Teacher teacher6 = new Teacher("Жанна Аркадьевна Черняк", 36, "физика");
        Teacher teacher7 = new Teacher("Эльдар Тимофеевич Друзь", 41, "геометрия");

        //создание учеников
        Pupil pupil1 = null;
        try {
            pupil1 = new Pupil("Сережа Полежайкин", 12, "анатомия");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil2 = null;
        try {
            pupil2 = new Pupil("Света Иванова", 14, "робототехника");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil3 = null;
        try {
            pupil3 = new Pupil("Женя Данилова", 12, "анатомия");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil4 = null;
        try {
            pupil4 = new Pupil("Наташа Ростова", 13, "химия");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil5 = null;
        try {
            pupil5 = new Pupil("Илья Обломов", 15, "геометрия");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil6 = null;
        try {
            pupil6 = new Pupil("Виктор Ан", 12, "математика");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil7 = null;
        try {
            pupil7 = new Pupil("Нина Печкина", 15, "робототехника");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil8 = null;
        try {
            pupil8 = new Pupil("Павлик Морозов", 11, "черчение");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil9 = null;
        try {
            pupil9 = new Pupil("Емеля Удалой", 13, "химия");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil10 = null;
        try {
            pupil10 = new Pupil("Скарлетт О'Хара", 12, "физика");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Pupil pupil11 = null;
        try {
            pupil11 = new Pupil("Варвара Лопухина", 14, "математика");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //добавляем учителей в школу
        school.addTeacher(teacher1); //Невозможно назначить учителя. Неизвестно количество вакантных мест
        school.setVacantPlacesForTeachers(11);
        System.out.println(Arrays.toString(school.teachers)); // [null, null, null, ....]
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addTeacher(teacher3);
        school.addTeacher(teacher4);
        school.addTeacher(teacher5);
        school.addTeacher(teacher6);
        school.addTeacher(teacher7);
        System.out.println(Arrays.toString(school.teachers));

        school.addPupil(pupil1); //Невозможно принять ученика. Неизвестно количество вакантных мест
        school.setVacantPlacesForPupils(20);
        school.addPupil(pupil1);
        school.addPupil(pupil2);
        school.addPupil(pupil3);
        school.addPupil(pupil4);
        school.addPupil(pupil5);
        school.addPupil(pupil6);
        school.addPupil(pupil7);
        school.addPupil(pupil8);
        school.addPupil(pupil9);
        school.addPupil(pupil10);
        school.addPupil(pupil11);
        System.out.println(Arrays.toString(school.pupils));

        assert pupil1 != null;
        System.out.println(pupil1.toString());
        System.out.println(pupil4.toString());
        assert pupil3 != null;
        System.out.println(pupil3.toString());
        assert pupil8 != null;
        System.out.println(pupil8.toString());

        school.schoolDay();

        school.extraLesson("алгебра");
        school.extraLesson("анатомия");
        System.out.println(pupil1.toString());
        System.out.println(pupil4.toString());
        System.out.println(pupil3.toString());
        System.out.println(pupil8.toString());
    }
}
