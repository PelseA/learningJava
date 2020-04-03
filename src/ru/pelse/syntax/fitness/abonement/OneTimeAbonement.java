package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.Pool;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalDate;
import java.time.LocalTime;

public class OneTimeAbonement extends SomeAbonement {
    // бассейн и тренажерный зал
    //public Pool pool = new Pool();

    public OneTimeAbonement(FitnessMember user) {
        super(user);
        zones[1] = "pool";
        time[1] = LocalTime.of(22, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = LocalDate.now();
    }
}
