package ru.pelse.syntax.farm;

public class Rabbit extends HomeAnimal implements CanBeEaten {

    public Rabbit(int speed, int health, int resource) {
        super(speed, health, resource);
    }

    @Override
    public void wasEaten() {
        setOnFarm(false);
    }
}
