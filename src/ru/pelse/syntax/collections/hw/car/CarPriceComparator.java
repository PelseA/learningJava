package ru.pelse.syntax.collections.hw.car;

import java.util.Comparator;

class CarPriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o2.getPrice(), o1.getPrice());
    }
}

class CarBrandComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class CarColorComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
