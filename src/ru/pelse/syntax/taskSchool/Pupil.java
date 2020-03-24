package ru.pelse.syntax.taskSchool;

public class Pupil extends EducationPersona implements ToLearn {

    private int level = 0;

    public Pupil(String name, int age, String subject) throws IllegalArgumentException {
        super(name, age, subject);
    }

    public int getLevel() {
        return level;
    }

    public void LevelUp(int mark) {
        this.level += mark;
    }

    @Override
    public void learn() {
        this.level += 5;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "level=" + level +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}' + "\n";
    }
}
