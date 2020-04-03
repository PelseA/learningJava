package ru.pelse.syntax.fitness;

import ru.pelse.syntax.fitness.abonement.SomeAbonement;
import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void showVisitorInfo(SomeAbonement abonement, Zone zone) {
        FitnessMember visitor = abonement.getMember();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String currentDataToStr = formatter.format(LocalDateTime.now());
        System.out.println("Новый посетитель " + visitor.getSurname() + " " + visitor.getName()
                            + " в " + zone.getTitle() + " "+ currentDataToStr );
    }

    public static void showVisitorsInZone(Zone zone) {
        SomeAbonement[] abonements = zone.getAbonements();
        System.out.println("Посетители спортивной зоны " + zone.getTitle() + ":");

        for (int i = 0; i < abonements.length; i++) {
            if (abonements[i] != null) {
                System.out.println(i+1 + ") " + abonements[i].getMember().getName()
                        + " " + abonements[i].getMember().getSurname());
            }
        }
    }
}
