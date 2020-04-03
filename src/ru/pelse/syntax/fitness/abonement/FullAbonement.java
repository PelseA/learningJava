package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.ZoneType;

import java.time.LocalTime;

public class FullAbonement extends SomeAbonement {
    // тренажерный зал, бассейн и групповые занятия
    public FullAbonement(FitnessMember user, int durationInMonths) throws IllegalArgumentException {
        super(user);
        setDurationInMonths(durationInMonths);
        zones[1] = ZoneType.POOL;
        zones[2] = ZoneType.GROUP;
        time[1] = LocalTime.of(22, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = registrationDate.plusMonths(durationInMonths);
    }
}
