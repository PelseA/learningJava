package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.ZoneType;

import java.time.LocalTime;

public class DailyAbonement extends SomeAbonement {
    // тренажерный зал и групповые занятия
    public DailyAbonement(FitnessMember user, int durationInMonths) {
        super(user);
        setDurationInMonths(durationInMonths);
        zones[1] = ZoneType.GROUP;
        time[1] = LocalTime.of(16, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = registrationDate.plusMonths(durationInMonths);
    }
}
