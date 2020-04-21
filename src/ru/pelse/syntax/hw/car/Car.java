package ru.pelse.syntax.hw.car;

import java.util.Objects;

public class Car {
    private String color;
    private String brand;
    private int price;

    public Car(String color, String brand, int price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPrice() == car.getPrice() &&
                Objects.equals(getColor(), car.getColor()) &&
                getBrand().equals(car.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getBrand(), getPrice());
    }
}
