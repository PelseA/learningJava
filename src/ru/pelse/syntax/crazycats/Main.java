package ru.pelse.syntax.crazycats;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.setName("Васька");

        Cat cat2 = new Cat(100, 9, 6); // health, age, weight(double)
        cat2.setName("Мурзик");
        cat2.setAge(7);

        Cat cat3 = new Cat(7, 65); // strength, age
        cat3.setWeight(6);
        cat3.setName("Рыжик");
        cat3.setColor("рыжий");

        Cat cat4 = new Cat("black", 100, 7); // color, health, age

        Address address = new Address();
        address.setCity("Москва");
        address.setStreet("Рыбная");
        address.setFloor(4);
        address.setHouse(54);

        Cat cat5 = new Cat(address, 7, "grey");

        //cat5.fight(cat4);
        cat2.fight(cat3);
    }
}
