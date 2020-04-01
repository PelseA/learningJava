package ru.pelse.syntax.farm;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(new Date().getTime());
        int minSpeed = 20;
        int maxSpeed = 40;
        int minHealth = 6;
        int maxHealth = 30;
        int minResource = 3;
        int maxResource = 27;
        int minStrength = 3;
        int maxStrength = 15;
        Farmer farmer = new Farmer();
        farmer.setName("Веселый фермер");
        // создаю домашних животных
        Cow cow = new Cow(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxHealth-minHealth+1)+minHealth,
                random.nextInt(maxResource-minResource+1)+minResource);
        cow.setName("Зорька");
        Cat cat = new Cat(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxHealth-minHealth+1)+minHealth,
                random.nextInt(maxResource-minResource+1)+minResource);
        cat.setName("Барсик");
        Rabbit rabbit1 = new Rabbit(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxHealth-minHealth+1)+minHealth,
                random.nextInt(maxResource-minResource+1)+minResource);
        rabbit1.setName("Кролик1");
        Rabbit rabbit2 = new Rabbit(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxHealth-minHealth+1)+minHealth,
                random.nextInt(maxResource-minResource+1)+minResource);
        rabbit2.setName("Кролик2");
        Chicken chicken = new Chicken(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxHealth-minHealth+1)+minHealth,
                random.nextInt(maxResource-minResource+1)+minResource);
        chicken.setName("Ряба");
        // создаю диких животных
        Fox fox = new Fox(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxStrength-minStrength+1)+minStrength);
        fox.setName("Лиса");
        fox.setCountAttack(3);
        Bear bear = new Bear(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxStrength-minStrength+1)+minStrength);
        bear.setName("Медведь");
        bear.setCountAttack(2);
        Wolf wolf = new Wolf(random.nextInt(maxSpeed-minSpeed+1)+minSpeed,
                random.nextInt(maxStrength-minStrength+1)+minStrength);
        wolf.setName("Волк");
        //создаю ферму
        Farm farm = new Farm(farmer);
        farm.addHomeAnimal(cow);
        farm.addHomeAnimal(rabbit1);
        farm.addHomeAnimal(rabbit2);
        farm.addHomeAnimal(chicken);
        farm.addHomeAnimal(cat);
        farm.addHomeAnimal(cat);// не должен добавиться
        farm.addWildAnimal(fox);
        farm.addWildAnimal(wolf);
        farm.addWildAnimal(bear);

        farm.passDay();
        farm.passDay();
        farm.passDay();

    }
}
