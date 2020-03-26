package ru.pelse.syntax.farm;

public class HomeAnimal extends Animal{
    protected int health;
    protected boolean onFarm;
    protected int resource = 0;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

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

    @Override
    public String toString() {
        return "HomeAnimal{" +
                "health=" + health +
                ", onFarm=" + onFarm +
                ", resource=" + resource +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
