package ru.pelse.syntax.taskSchool;

public interface ToTeach {
    void teach(ToLearn pupil);

    //можно прибавить level ученику
    void improvePupil(Pupil pupil, int mark);
}
