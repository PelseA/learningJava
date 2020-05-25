package ru.pelse.syntax.multithreading.cafe;

import java.util.Objects;

public class Order {
    private Meal meal;
    private Drink drink;

    public Order() {
        this.meal = Meal.randomMeal();
        this.drink = Drink.randomDrink();
    }

    public Meal getMeal() {
        return meal;
    }

    public Drink getDrink() {
        return drink;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meal=" + meal +
                ", drink=" + drink +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getMeal() == order.getMeal() &&
                getDrink() == order.getDrink();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeal(), getDrink());
    }
}
