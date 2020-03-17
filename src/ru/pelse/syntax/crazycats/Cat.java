package ru.pelse.syntax.crazycats;

public class Cat {
    private String name = "Anonymous";
    private int age = 3;
    private String color = "white";
    private Address ownerAddress;
    private int weight = 3;
    private int strength = 5;
    private int health = 75;

    public Cat() {}

    public Cat(Address ownerAddress, int age, String color) {
        ValidationCat validator = new ValidationCat();
        this.ownerAddress = ownerAddress;
        this.health  +=  validator.dependenceHealthOnFloor(ownerAddress);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(age);
        this.color = color;
        this.strength += validator.dependenceStrengthOnColor(color);
    }

    public Cat(int health, int age, int weight) {
        ValidationCat validator = new ValidationCat();
        this.health = validator.validationHealth(health);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(age);
        this.weight =validator.validationWeight(weight);
        this.strength += validator.dependenceStrengthOnWeight(this.weight);
    }

    public Cat(int strength, int age) {
        ValidationCat validator = new ValidationCat();
        strength = validator.validationStrength(strength);
        this.strength = strength;
        age = validator.validationAge(age);
        this.age = age;
    }

    public Cat(String color, int health, int age) {
        ValidationCat validator = new ValidationCat();
        this.color = color;
        this.strength += validator.dependenceStrengthOnColor(color);
        this.health = validator.validationHealth(health);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(this.age);
    }

    public void setName(String name) {
        if(name.length() > 2) this.name = name;
        else System.out.println("Имя должно состоять из 3 и более символов.");
    }

    public void setAge(int age) {
        if(age < 3 || age > 10) {
            System.out.println("К бою допускаются коты от 3 до 10 лет.");
        }
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwnerAddress(Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setWeight(int weight) {
        if(weight < 3 || weight > 15) {
            System.out.println("К бою допускаются коты от 3 до 15 кг.");
        }
        else this.weight = weight;
    }

    public void setStrength(int strength) {
        if(strength > 10 || strength < 6) {
            System.out.println("Значение силы должно быть от 6 до 10");
        }
        else this.strength = strength;
    }

    public void setHealth(int health) {
        if(health > 100 || health < 51) {
            System.out.println("Значение здоровья должно быть от 51 до 100");
        }
        else this.health = health;
    }

    public void fight(Cat anotherCat) {
        System.out.println(this);
        System.out.println(anotherCat);
        while(this.health > 5 && anotherCat.health > 5) {
            this.health = this.health - anotherCat.strength;
            anotherCat.health = anotherCat.health - this.strength;
            if(this.health <= 5 && this.health < anotherCat.health) {
                System.out.println("Кот " + this.name + " не может продолжать бой");
                System.out.println("Победил " + anotherCat.name);
            }
            if(anotherCat.health <= 5 && anotherCat.health < this.health) {
                System.out.println("Кот " + anotherCat.name + " не может продолжать бой");
                System.out.println("Победил " + this.name);
            }
        }
        System.out.println(this);
        System.out.println(anotherCat);
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name= '" + name + '\'' +
                ", age= " + age +
                ", color= '" + color + '\'' +
                ", ownerAddress= " + ownerAddress +
                ", weight= " + weight +
                ", strength= " + strength +
                ", health= " + health +
                '}';
    }

}
