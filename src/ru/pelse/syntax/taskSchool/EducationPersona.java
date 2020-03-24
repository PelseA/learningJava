package ru.pelse.syntax.taskSchool;

public abstract class EducationPersona extends Persona {

    String subject;

    public EducationPersona(String name, int age, String subject) throws IllegalArgumentException {
        super(name, age);
        setSubject(subject);
    }

    public void setSubject(String subject) {
        if(subject.length() >= 3) {
            this.subject = subject;
        } else {
            System.out.println("Название предмета не может быть короче 3 символов");
        }
    }

}
