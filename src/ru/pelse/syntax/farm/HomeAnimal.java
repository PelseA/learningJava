package ru.pelse.syntax.farm;

public class HomeAnimal extends Animal{
    protected int health;
    protected boolean onFarm;

    public boolean isOnFarm() {
        return onFarm;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
