package ru.pelse.syntax.taskSchool;
//школа не может быть без директора
//метод школьный день предметы у учеников и учителя должны совпадать, тогда учителя учат этих учеников
abstract public class Persona {
    protected String name;

    protected int age;

    public Persona(String name, int age) throws IllegalArgumentException {
        if(name.length() > 4) {
            this.name = name;
        }
        setAge(age);
    }

    public void setAge(int age) throws IllegalArgumentException {
        if(age > 6) this.age = age;
    }
}
