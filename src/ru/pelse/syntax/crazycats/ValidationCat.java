package ru.pelse.syntax.crazycats;

public class ValidationCat {
    protected int validationAge(int age) {
        if (age > 10) {
            System.out.println("Попытка создать кота с недопустимым возрастом более 10, " +
                    "установлено максимальное значение 10" );
            return 10;
        }
        else if (age < 3) {
            System.out.println("Попытка создать кота с недопустимым возрастом менее 3, " +
                    "установлено минимальное значение 3" );
            return 3;
        }
        else return age;
    }

    protected int validationStrength(int strength) {
        if (strength > 10) {
            System.out.println("Попытка создать кота с недопустимой силой более 10, " +
                    "установлено максимальное значение 10" );
            return 10;
        }
        else if (strength < 5) {
            System.out.println("Попытка создать кота с недопустимой силой менее 5, " +
                    "установлено минимальное значение 5" );
            return 5;
        }
        else return strength;
    }

    protected int validationHealth(int health) {
        if (health > 100) {
            System.out.println("Попытка создать кота с недопустимым здоровьем более 100, " +
                    "установлено максимальное значение" );
            return 100;
        }
        else if (health < 50) {
            System.out.println("Попытка создать кота с недопустимым здоровьем менее 50, " +
                    "установлено минимальное значение" );
            return 50;
        }
        else return health;
    }

    protected int validationWeight(int weight) {
        if (weight > 15) {
            System.out.println("Попытка создать кота с недопустимой массой более 15, " +
                    "установлено максимальное значение" );
            return 15;
        }
        else if (weight < 3) {
            System.out.println("Попытка создать кота с недопустимой массой менее 3, " +
                    "установлено минимальное значение" );
            return 3;
        }
        else return weight;
    }

    protected int dependenceStrengthOnAge(int age) {
        if (age >=3 && age <= 7) return 1;
        if (age > 7) return -1;
        else return 0;
    }

    protected int dependenceHealthOnFloor(Address address) {
        return address.getFloor() >= 3 && address.getFloor() <= 5 ? 10 : 0;
    }

    protected int dependenceStrengthOnWeight(int weight) {
        if (weight <= 4) return -1;
        if (weight >= 6 && weight <= 8) return 1;
        else return 0;
    }

    protected int dependenceStrengthOnColor(String color) {
        if ("black".equals(color) || "черный".equals(color) || "чёрный".equals(color)) return 1;
        else return 0;
    }
}
