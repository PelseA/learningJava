package ru.pelse.syntax.training;

public class ImplemintationFirst implements First{
    @Override
    public void firstMethod() {
        System.out.println("Метод первого интерфейса First");
    }

    @Override
    public void mainMethod() {
        System.out.println("Метод общего интерфейса MainInterface");
    }
}
