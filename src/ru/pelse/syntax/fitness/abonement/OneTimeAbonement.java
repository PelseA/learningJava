package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.ZoneType;

import java.time.LocalDate;
import java.time.LocalTime;

public class OneTimeAbonement extends SomeAbonement {
    // бассейн и тренажерный зал
    public OneTimeAbonement(FitnessMember user) {
        super(user);
        zones[1] = ZoneType.POOL;
        time[1] = LocalTime.of(22, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = LocalDate.now();
    }
}
