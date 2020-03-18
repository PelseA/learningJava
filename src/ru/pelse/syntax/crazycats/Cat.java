package ru.pelse.syntax.crazycats;

public class Cat {
    private String name = "Anonymous";
    private int age = 3;
    private String color = "white";
    private Address ownerAddress;
    private int weight = 3;
    private int strength = 5;
    private int health = 75;
    private int typeConstructor;

    public Cat() {
        this.typeConstructor = 0;
    }

    public Cat(Address ownerAddress, int age, String color) {
        ValidationCat validator = new ValidationCat();
        this.ownerAddress = ownerAddress;
        this.health  +=  validator.dependenceHealthOnFloor(ownerAddress);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(age);
        this.color = color;
        this.strength += validator.dependenceStrengthOnColor(color);
        this.typeConstructor = 1;
    }

    public Cat(int health, int age, int weight) {
        ValidationCat validator = new ValidationCat();
        this.health = validator.validationHealth(health);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(age);
        this.weight =validator.validationWeight(weight);
        this.strength += validator.dependenceStrengthOnWeight(this.weight);
        this.typeConstructor = 2;
    }

    public Cat(int strength, int age) {
        ValidationCat validator = new ValidationCat();
        strength = validator.validationStrength(strength);
        this.strength = strength;
        age = validator.validationAge(age);
        this.age = age;
        this.typeConstructor = 3;
    }

    public Cat(String color, int health, int age) {
        ValidationCat validator = new ValidationCat();
        this.color = color;
        this.strength += validator.dependenceStrengthOnColor(color);
        this.health = validator.validationHealth(health);
        this.age = validator.validationAge(age);
        this.strength += validator.dependenceStrengthOnAge(this.age);
        this.typeConstructor = 4;
    }

    public void setName(String name) {
        if(name != null && name.length() > 2) this.name = name;
        else System.out.println("Имя должно состоять из 3 и более символов.");
    }

    public void setAge(int age) {
        int type = this.getTypeConstructor();
        if(type == 1 || type == 2 || type == 3 || type == 4) {
            System.out.println("Вы установили возраст при создании кота. Невозможно изменить этот параметр.");
        }
        else if(age < 3 || age > 10) {
            System.out.println("К бою допускаются коты от 3 до 10 лет. Установите другое значение.");
        }
        else this.age = age;
    }

    public void setColor(String color) {
        if (this.getTypeConstructor() == 1 || this.getTypeConstructor() == 4) {
            System.out.println("Вы установили цвет при создании кота. Невозможно изменить этот параметр.");
        }
        else this.color = color;
        if("black".equals(color)) this.strength++;
    }

    public void setOwnerAddress(Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setWeight(int weight) {
        if(this.getTypeConstructor() == 2) {
            System.out.println("Вы установили вес при создании кота. Невозможно изменить этот параметр.");
        }
        else if(weight < 3 || weight > 15) {
            System.out.println("К бою допускаются коты от 3 до 15 кг. Установите допустимый вес.");
        }
        else this.weight = weight;
    }

    public void setStrength(int strength) {
        if(this.getTypeConstructor() == 3) {
            System.out.println("Вы установили силу при создании кота. Невозможно изменить этот параметр.");
        }
        else if(strength > 10 || strength < 6) {
            System.out.println("Значение силы должно быть от 6 до 10. Установите другое значение.");
        }
        else this.strength = strength;
    }

    public void setHealth(int health) {
        int type = this.getTypeConstructor();
        if(type == 2 || type == 4) {
            System.out.println("Вы установили здоровье при создании кота. Невозможно изменить этот параметр.");
        }
        if(health > 100 || health < 51) {
            System.out.println("Значение здоровья должно быть от 51 до 100");
        }
        else this.health = health;
    }

    public void fight(Cat anotherCat) {
        if (this != anotherCat) {
            System.out.println("В правом углу ринга " + this);
            System.out.println("В левом углу ринга "  + anotherCat);
            while(this.health > 5 && anotherCat.health > 5) {
                this.health = this.health - anotherCat.strength;
                anotherCat.health = anotherCat.health - this.strength;
                if(this.health <= 5 && this.health < anotherCat.health) {
                    System.out.println("Кот " + this.name + " не может продолжать бой. Его здоровье " + this.health);
                    System.out.println("Победил " + anotherCat.name + " остаток здоровья " + anotherCat.health);
                }
                if(anotherCat.health <= 5 && anotherCat.health < this.health) {
                    System.out.println("Кот " + anotherCat.name + " не может продолжать бой. Его здоровье " + anotherCat.health);
                    System.out.println("Победил " + this.name + " остаток здоровья " + this.health);
                }
            }
            System.out.println(this);
            System.out.println(anotherCat);
        } else {
            System.out.println("Нельзя приченить себе ущерб.");
        }

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

    public int getTypeConstructor() {
        return typeConstructor;
    }
}
