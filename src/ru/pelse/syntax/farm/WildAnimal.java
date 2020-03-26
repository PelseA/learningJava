package ru.pelse.syntax.farm;

public class WildAnimal extends Animal {
    protected int strength;

    public WildAnimal(int speed, int strength) {
        super(speed);
        this.setStrength(strength);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(HomeAnimal animal) {
        if(speed > animal.speed) {
            System.out.println(this.getName() + " напал(-а) на домашнее животное " + animal.getName());
            animal.health -= strength;
            if(animal.health <= 0) {
                animal.setOnFarm(false);
            }
        }
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "strength=" + strength +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
