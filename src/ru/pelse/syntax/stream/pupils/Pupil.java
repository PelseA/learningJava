package ru.pelse.syntax.stream.pupils;

import java.time.LocalDate;
import java.util.UUID;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(String name, Gender gender, LocalDate birth) {
        this.number = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public UUID getNumber() {
        return number;
    }

    public void setNumber(UUID number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}'+ "\n";
    }
}