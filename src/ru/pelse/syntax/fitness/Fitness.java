package ru.pelse.syntax.fitness;

import ru.pelse.syntax.fitness.abonement.SomeAbonement;
import ru.pelse.syntax.fitness.zone.Group;
import ru.pelse.syntax.fitness.zone.Gym;
import ru.pelse.syntax.fitness.zone.Pool;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalTime;

public class Fitness {
    public Pool pool;
    public Gym gym;
    public Group group;

    public Fitness(Pool pool, Gym gym, Group group) {
        this.pool = pool;
        this.gym = gym;
        this.group = group;
    }

    public void closeFitness() {
        pool.closeZone();
        gym.closeZone();
        group.closeZone();
    }

    // себе: абонемент хранит инфо о member
    // desiredZone must be "pool" || "gym" || "group"
    public void addMember(SomeAbonement abonement, String desiredZone) {
        //LocalTime currentTime = LocalTime.now();
        LocalTime currentTime = LocalTime.of(8, 0);
        String[] zones = abonement.getZones();
        if (!currentTime.isAfter(abonement.getTime()[0]) && !abonement.getTime()[1].isBefore(currentTime)) {
            if (currentTime.equals(abonement.getTime()[0])) {
                checkZone(abonement, desiredZone, zones);
            } else {
                System.out.println("В это время вы не можете посетить ");
            }
        } else {
            checkZone(abonement, desiredZone, zones);
        }
    }

    private void checkZone(SomeAbonement abonement, String desiredZone, String[] zones) {
        Zone potentialZone = null;
        boolean zoneExist = false;
        for (String zone: zones) {
            if (zone != null) {
                if(zone.equals(desiredZone)) {
                    zoneExist = true;
                    if(pool.getTitle().equals(zone)) {
                        potentialZone = pool;
                    }
                    if(gym.getTitle().equals(zone)) {
                        potentialZone = gym;
                    }
                    if(group.getTitle().equals(zone)) {
                        potentialZone = group;
                    }
                }
            }
        }
        if(!zoneExist) {
            System.out.println("По вашему абонементу нельзя в спортивную зону " + desiredZone);
        }
        if(potentialZone != null) {
            if(potentialZone.addAbonement(abonement)){
                Logger.showVisitorInfo(abonement, potentialZone);
            }
        }
        zoneExist = false;
    }

    public void showVisitors() {
        Logger.showVisitorsInZone(gym);
        Logger.showVisitorsInZone(pool);
        Logger.showVisitorsInZone(group);
    }
}
