package ru.pelse.syntax.farm;

import java.util.Date;
import java.util.Random;

public class Farm {
    Farmer farmer;
    HomeAnimal[] homeAnimals = new HomeAnimal[10];
    WildAnimal[] wildAnimals = new WildAnimal[3];
    Random random = new Random(new Date().getTime());

    public Farm(Farmer farmer) {
        this.farmer = farmer;
    }

    public void addHomeAnimal(HomeAnimal animal) {
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] == null && homeAnimals[i] != animal) {
                homeAnimals[i] = animal;
                animal.setOnFarm(true);
                return;
            }
        }
    }

    public void addWildAnimal(WildAnimal animal) {
        for (int i = 0; i < wildAnimals.length; i++) {
            if (wildAnimals[i] == null && wildAnimals[i] != animal) {
                wildAnimals[i] = animal;
                return;
            }
        }
    }

    protected HomeAnimal giveRandomHomeAnimal() {
        int randIndex = random.nextInt(homeAnimals.length);
        if(homeAnimals[randIndex] == null) {
            return giveRandomHomeAnimal();
        }
        return homeAnimals[randIndex];
    }

    protected WildAnimal giveRandomWildAnimal() {
        int randIndex = random.nextInt(wildAnimals.length);
        if(wildAnimals[randIndex] == null) {
            return giveRandomWildAnimal();
        }
        return wildAnimals[randIndex];
    }

    public void passDay() {
        // 1 Фермер тратит 2 единицы ресурсов (если ресурсов не осталось, игра заканчивается).
        farmer.useSelfResource();
        if (farmer.resource <= 0) {
            System.out.println("Игра закончилась. Фермер исчерпал свои ресурсы");
            return;
        }
        // 2 Приходит дикое животное (выбирается рандомно из массива с дикими животными), пытается поймать
        // (съесть, либо ранить) домашнее животное (выбирается рандомно).
        // Если домашнее животное убежало, дикое уходит ни с чем.
        // 3 Иногда (рандомно) фермер может прогнать дикое животное.
        WildAnimal randWildAnimal = giveRandomWildAnimal();
        if (!farmer.kickAnimal(randWildAnimal)) {
            randWildAnimal.attack(giveRandomHomeAnimal());
        } else {
            System.out.println("Фермер прогнал дикое животное");
        }

        // 4 Фермер кормит всех животных (животные восполняют здоровье)
        for (HomeAnimal an : homeAnimals) {
            if (an != null) {
                if (an.isOnFarm()) farmer.feedAnimal(an);
            }
        }

        // 5 Фермер собирает ресурсы с животных, с которых можно их собирать.
        // Если таких не осталось, съедает животное, пригодное в пищу (если такие остались).
        int resBefore = farmer.resource;
        for (HomeAnimal resAn : homeAnimals) {
            if (resAn != null) {
                if (resAn instanceof GivesResources) {
                    if (resAn.isOnFarm()) {
                        farmer.takeResources((GivesResources) resAn);
                    }
                }
            }
        }
        if (resBefore == farmer.resource) {
            for (HomeAnimal eatenAn : homeAnimals) {
                if(eatenAn != null) {
                    if (eatenAn instanceof CanBeEaten) {
                        if (eatenAn.isOnFarm()) {
                            farmer.eatAnimal((CanBeEaten) eatenAn);
                            break;
                        }
                    }
                }
            }
        }
    }
}
