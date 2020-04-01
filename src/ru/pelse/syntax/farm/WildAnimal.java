package ru.pelse.syntax.farm;

public class WildAnimal extends Animal {
    protected int strength;

    protected int countAttack = 0;

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

    public int getCountAttack() {
        return countAttack;
    }

    public void setCountAttack(int countAttack) {
        this.countAttack = countAttack;
    }

    public void attack(HomeAnimal animal) {
        if(countAttack <= 3) {
            if(speed > animal.speed) {
                System.out.println(this.getName() + " напал(-а) на домашнее животное " + animal.getName());
                animal.health -= strength;
                if(animal.health <= 0) {
                    animal.setOnFarm(false);
                }
                countAttack++;
            }
        } else {
            System.out.println(name + " уже в " + countAttack + " раз устраивает набег. Попытки исчерпаны.");
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
