package ru.pelse.syntax.taskSchool;

public class Director extends Persona {

    public Director(String name, int age) throws IllegalArgumentException {
        super(name, age);
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age < 30) throw new IllegalArgumentException("Director age must be more then 29");
        this.age = age;
    }

    public void startClass() {
        System.out.println("Объявляет начало учебного дня");
    }

    public void finishClass() {
        System.out.println("Объявляет окончание заниятий");
    }

    @Override
    public String toString() {
        return name + ", " + "возраст: " + age;
    }
}
