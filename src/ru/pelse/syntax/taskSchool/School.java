package ru.pelse.syntax.taskSchool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class School {
    //название школы неизменно
    final String TITLE;
    Director director;
    Teacher[] teachers;
    Pupil[] pupils;
    private int vacantPlacesForTeachers;
    private int vacantPlacesForPupils;

    public School(String title, Director director) {
        this.TITLE = title;
        setDirector(director);
        System.out.println("Открыта школа " + title + "\n" + "Директор школы " + this.director.toString());
    }

    public int getVacantPlacesForTeachers() {
        return vacantPlacesForTeachers;
    }

    public void setVacantPlacesForTeachers(int vacantPlacesForTeachers) {
        if (vacantPlacesForTeachers < 2) {
            System.out.println("Количество вакантных мест должно быть не менее 2");
            return;
        }
        this.vacantPlacesForTeachers = vacantPlacesForTeachers;
        this.teachers = new Teacher[vacantPlacesForTeachers];
    }

    public int getVacantPlacesForPupils() {
        return vacantPlacesForPupils;
    }

    public void setVacantPlacesForPupils(int vacantPlacesForPupils) {
        if (vacantPlacesForPupils < 2) {
            System.out.println("Количество вакантных мест должно быть не менее 2");
            return;
        }
        this.vacantPlacesForPupils = vacantPlacesForPupils;
        this.pupils = new Pupil[vacantPlacesForPupils];
    }

    public Teacher[] getTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
        return teachers;
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) {
            System.out.println("Невозможно назначить учителя. Неизвестно количество вакантных мест");
            return;
        }
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            }
        }
    }

    public void addPupil(Pupil pupil) {
        if (pupils == null) {
            System.out.println("Невозможно принять ученика. Неизвестно количество вакантных мест");
            return;
        }
        for (int i = 0; i < pupils.length; i++) {
            if (pupils[i] == null) {
                pupils[i] = pupil;
                return;
            }
        }
    }

    public void schoolDay() {
        director.startClass();
        String[][] classes = new String[teachers.length][3]; //3 - преподаватель, предмет, ученики
        for (int i = 0; i < classes.length; i++) {
            if (teachers[i] != null) {
                classes[i][0] = teachers[i].name;
                classes[i][1] = teachers[i].subject;
                classes[i][2] = "Ученики: ";
            }
        }
        for (Pupil pupil : pupils) {
            if (pupil != null) {
                for (int j = 0; j < classes.length; j++) {
                    if (classes[j][1] != null) {
                        if (classes[j][1].equals(pupil.subject)) {
                            classes[j][2] += pupil.name + ", ";
                            //ученики сами пришли учиться вызовем метод learn у ученика (я так хочу)
                            pupil.learn();
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(classes));
        director.finishClass();
    }

    //а здесь использую List и LinkedList
    public void extraLesson(String subject) {
        List<EducationPersona> extraClass = new LinkedList<>();
        boolean existTeacher = false;
        for (Teacher t : teachers) {
            if (t != null) {
                if (t.subject.equals(subject)) {
                    extraClass.add(t);
                    existTeacher = true;
                    for (Pupil p : pupils) {
                        if (p != null) {
                            if (p.subject.equals(subject)) {
                                //на дополнительных занятиях учитель учит ученика поэтому у учителя вызову teach(ученик)
                                t.teach(p);
                                extraClass.add(p);
                            }
                        }
                    }
                }
            }
        }
        if (!existTeacher) {
            System.out.println("Нам нужен преподаватель по предмету " + subject);
        }
        System.out.println(extraClass.toString());
    }
}
