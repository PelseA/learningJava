package ru.pelse.syntax.fitness.member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AdultMember extends FitnessMember implements Member {
    protected int minAge = 18;

    public AdultMember(String name, String surname, LocalDate dateOfBirth) throws IllegalArgumentException {
        super(name, surname, dateOfBirth);
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(currentDate, dateOfBirth);
        if (diff >= minAge) {
            this.dateOfBirth = dateOfBirth;
        }
    }

}
