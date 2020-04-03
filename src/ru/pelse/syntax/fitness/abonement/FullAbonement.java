package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.member.Member;
import ru.pelse.syntax.fitness.zone.Group;
import ru.pelse.syntax.fitness.zone.Pool;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalTime;

public class FullAbonement extends SomeAbonement {
    // тренажерный зал, бассейн и групповые занятия
    public Group group = new Group();
    public Pool pool = new Pool();
    public FullAbonement(FitnessMember user, int durationInMonths) throws IllegalArgumentException {
        super(user);
        setDurationInMonths(durationInMonths);
        zones[1] = "pool";
        zones[2] = "group";
        time[1] = LocalTime.of(22, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = registrationDate.plusMonths(durationInMonths);
    }
}
