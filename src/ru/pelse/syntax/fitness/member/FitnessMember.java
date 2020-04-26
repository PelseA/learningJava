package ru.pelse.syntax.fitness.member;

import java.time.LocalDate;

abstract public class FitnessMember implements Member{
    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;

    public FitnessMember(String name, String surname, LocalDate dateOfBirth) throws IllegalArgumentException {
        setName(name);
        setSurname(surname);
        // из интерфейса Member
        setDateOfBirth(dateOfBirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length() >= 2) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws IllegalArgumentException {
        if (surname.length() >= 2) {
            this.surname = surname;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "FitnessMember{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
