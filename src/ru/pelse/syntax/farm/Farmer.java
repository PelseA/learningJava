package ru.pelse.syntax.farm;

import java.util.Date;
import java.util.Random;

public class Farmer {
    String name = "Фермер";
    Random random = new Random(new Date().getTime());
    int resource = 5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public void takeResources(GivesResources animal) {

    }

    public void eatAnimal(CanBeEaten animal) {

    }

    public boolean kickAnimal(WildAnimal animal) {
        return random.nextBoolean();
    }

    public void feedAnimal(HomeAnimal animal) {
        animal.health += 3;
    }

    public void useResource() {
        resource -= 1;
    }
}
