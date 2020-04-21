package ru.pelse.syntax.hw.car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparingExample {
    public static void main(String[] args) {
        // Дополнительное домашнее задание
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        // Объекты добавить в ArrayList cars
        List<Car> cars = new ArrayList<>(5);
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);
        System.out.println("До сортировки: \n" + cars);

        // отсортировать объекты в cars сначала по brand, price, color
        // cars.sort(компаратор);
        Comparator<Car> carComparator = new CarBrandComparator()
                .thenComparing(new CarPriceComparator()
                .thenComparing(new CarColorComparator()));
        cars.sort(carComparator);

        System.out.println("После сортировки: \n" + cars);
    }
}
