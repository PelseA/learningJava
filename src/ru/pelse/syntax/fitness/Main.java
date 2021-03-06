package ru.pelse.syntax.fitness;

import ru.pelse.syntax.fitness.abonement.DailyAbonement;
import ru.pelse.syntax.fitness.abonement.FullAbonement;
import ru.pelse.syntax.fitness.abonement.OneTimeAbonement;
import ru.pelse.syntax.fitness.member.AdultMember;
import ru.pelse.syntax.fitness.zone.Group;
import ru.pelse.syntax.fitness.zone.Gym;
import ru.pelse.syntax.fitness.zone.Pool;
import ru.pelse.syntax.fitness.zone.ZoneType;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Pool pool = new Pool();
        Gym gym = new Gym();
        Group group = new Group();

        Fitness fitness = new Fitness(pool, gym, group);
        // String name, String surname, Date dateOfBirth
        AdultMember visitor1 = new AdultMember("Иван", "Поляков",
                LocalDate.of(1990, Month.OCTOBER, 17));
        AdultMember visitor2 = new AdultMember("Евгения", "Родная",
                LocalDate.of(1960, Month.NOVEMBER, 3));
        AdultMember visitor3 = new AdultMember("Лев", "Троцкий",
                LocalDate.of(1981, Month.JULY, 11));
        AdultMember visitor4 = new AdultMember("Алена", "Савельева",
                LocalDate.of(1992, Month.APRIL, 23));
        AdultMember visitor5 = new AdultMember("Денис", "Ушаков",
                LocalDate.of(1975, Month.OCTOBER, 8));

        OneTimeAbonement oneTimeAbonement1 = new OneTimeAbonement(visitor1);
        OneTimeAbonement oneTimeAbonement2 = new OneTimeAbonement(visitor2);
        FullAbonement fullAbonement1 = new FullAbonement(visitor3, 2);
        FullAbonement fullAbonement2 = new FullAbonement(visitor4, 6);
        DailyAbonement dailyAbonement = new DailyAbonement(visitor5, 6);

        fitness.addMember(oneTimeAbonement1, ZoneType.POOL);
        fitness.addMember(oneTimeAbonement2, ZoneType.GYM);
        fitness.addMember(fullAbonement1, ZoneType.GYM);
        fitness.addMember(fullAbonement2, ZoneType.POOL);
        fitness.addMember(dailyAbonement, ZoneType.POOL);

        // проверка на повторное (одновременное) посещение спортивной зоны
        fitness.addMember(fullAbonement2, ZoneType.POOL);

        fitness.showVisitors();

    }
}
