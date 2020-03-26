package ru.pelse.syntax.farm;

public class Rabbit extends HomeAnimal implements CanBeEaten {

    @Override
    public void wasEaten() {
        setOnFarm(false);
    }
}
