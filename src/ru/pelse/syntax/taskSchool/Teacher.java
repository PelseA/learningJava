package ru.pelse.syntax.taskSchool;

public class Teacher extends EducationPersona implements ToTeach {

    public Teacher(String name, int age, String subject) throws IllegalArgumentException {
        super(name, age, subject);
    }

    @Override
    public void teach(ToLearn pupil) {
        pupil.learn();
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age < 20) throw new IllegalArgumentException("Teacher age must be more then 19");
        this.age = age;
    }


    //учитель повышает уровень ученика
    @Override
    public void improvePupil(Pupil pupil, int mark) {
        pupil.LevelUp(mark);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}' + "\n";
    }
}
