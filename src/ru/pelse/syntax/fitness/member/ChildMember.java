package ru.pelse.syntax.fitness.member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChildMember extends FitnessMember implements Member{
    protected int minAge = 12;
    protected int maxAge = 17;

    public ChildMember(String name, String surname, LocalDate dateOfBirth) throws IllegalArgumentException {
        super(name, surname, dateOfBirth);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(currentDate, dateOfBirth);
        if (diff >= minAge && diff < maxAge) {
            this.dateOfBirth = dateOfBirth;
        }
    }
}
