package ru.pelse.syntax.farm;

public class HomeAnimal extends Animal{
    protected int health;
    protected int primaryHealth;
    protected boolean onFarm;
    protected int resource;

    public HomeAnimal(int speed, int health, int resource) {
        super(speed);
        this.setHealth(health);
        this.setResource(resource);
        this.primaryHealth = health;
    }

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

    public int getPrimaryHealth() {
        return primaryHealth;
    }

    public void addHealth() {
        if(this.health < getPrimaryHealth()) {
            this.health += 1;
        }
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
