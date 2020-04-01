package ru.pelse.syntax.farm;

import java.util.Date;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

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
        resource += animal.giveResource();
        System.out.println(this.getName() + " собрал ресурсы");
    }

    public void eatAnimal(CanBeEaten animal) {
        animal.wasEaten();
        System.out.println(this.getName() + " съел " + animal.toString());
    }

    public boolean kickAnimal(WildAnimal animal) {
        return random.nextBoolean();
    }

    public void feedAnimal(HomeAnimal animal) {
        animal.addHealth();
        System.out.println(this.getName() + " покормил животное по имени " + animal.getName());
    }

    public void useSelfResource() {
        resource -= 1;
    }
}
