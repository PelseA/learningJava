package ru.pelse.syntax.training;

public class ImplemintationSecond implements Second {
    @Override
    public void secondMethod() {
        System.out.println("Метод второго интерфейса Second");
    }

    @Override
    public void mainMethod() {
        System.out.println("Метод общего интерфейса MainInterface");
    }
}
