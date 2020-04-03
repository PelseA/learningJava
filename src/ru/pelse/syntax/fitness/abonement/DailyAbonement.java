package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.member.Member;
import ru.pelse.syntax.fitness.zone.Group;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalTime;

public class DailyAbonement extends SomeAbonement {
    // тренажерный зал и групповые занятия
    public Group group = new Group();
    public DailyAbonement(FitnessMember user, int durationInMonths) {
        super(user);
        setDurationInMonths(durationInMonths);
        zones[1] = "group";
        time[1] = LocalTime.of(16, 0);
    }

    @Override
    public void setRegistrationExpiration() {
        this.registrationExpiration = registrationDate.plusMonths(durationInMonths);
    }
}
