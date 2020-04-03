package ru.pelse.syntax.fitness.abonement;

import ru.pelse.syntax.fitness.member.FitnessMember;
import ru.pelse.syntax.fitness.zone.Gym;
import ru.pelse.syntax.fitness.zone.Zone;

import java.time.LocalDate;
import java.time.LocalTime;

abstract public class SomeAbonement implements Abonement {
    protected FitnessMember member;
    protected LocalDate registrationDate = LocalDate.now();
    protected LocalDate registrationExpiration;
    protected int durationInMonths;
    //тренажерный зал можно посещать всем
    public Gym gym = new Gym();
    protected String[] zones = new String[3];
    //индекс 0 - начало, индекс 1 - окончание
    protected LocalTime[] time = new LocalTime[2];
    protected boolean currentlyRegisterInZone = false;

    public SomeAbonement(FitnessMember member) throws IllegalArgumentException{
        this.member = member;
        setRegistrationExpiration();
        zones[0] = "gym";
        time[0] = LocalTime.of(8, 0);
    }

    public FitnessMember getMember() {
        return member;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getRegistrationExpiration() {
        return registrationExpiration;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) throws IllegalArgumentException {
        // 0 - для абонементов класса OneTimeAbonement
        if(durationInMonths >= 0) {
            this.durationInMonths = durationInMonths;
        }
    }

    public String[] getZones() {
        return zones;
    }

    public void setZones(String[] zones) {
        this.zones = zones;
    }

    public LocalTime[] getTime() {
        return time;
    }

    public void setTime(LocalTime[] time) {
        this.time = time;
    }

    public boolean isCurrentlyRegisterInZone() {
        return currentlyRegisterInZone;
    }

    public void setCurrentlyRegisterInZone(boolean currentlyRegisterInZone) {
        this.currentlyRegisterInZone = currentlyRegisterInZone;
    }
}
