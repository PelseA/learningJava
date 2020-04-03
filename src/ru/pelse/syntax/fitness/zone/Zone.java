package ru.pelse.syntax.fitness.zone;

import ru.pelse.syntax.fitness.abonement.SomeAbonement;

import java.util.Arrays;

abstract public class Zone {
    protected String title;
    protected SomeAbonement[] abonements;

    public Zone() {
        this.abonements = new SomeAbonement[20];
    }

    public SomeAbonement[] getAbonements() {
        return abonements;
    }

    public void setAbonements(SomeAbonement[] abonements) {
        this.abonements = abonements;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean addAbonement(SomeAbonement newAbonement) {
        for (int i = 0; i < abonements.length; i++) {
            if(abonements[i] == newAbonement) {
                System.out.println("Повторная регистрация для "
                        + abonements[i].getMember().getSurname() + " "
                        + abonements[i].getMember().getName() + " невозможна" );
                return false;
            } else if( abonements[i] == null) {
                abonements[i] = newAbonement;
                System.out.println("Из addAbonemet "+ Arrays.toString(abonements));
                newAbonement.setCurrentlyRegisterInZone(true);
                return true;
            }
        }
        return false;
    }

    public void closeZone() {
        for (SomeAbonement ab: abonements) {
            ab.setCurrentlyRegisterInZone(false);
            ab = null;
        }
    }
}
