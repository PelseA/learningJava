package ru.pelse.syntax.training;

public class Test {
    public static void main(String[] args) {
        ImplemintationFirst someClass1 = new ImplemintationFirst();
        ImplemintationSecond someClass2 = new ImplemintationSecond();

        //Porridge porridge = new Porridge(someClass1);
        Porridge porridge = new Porridge(someClass2);
        porridge.cookPorridge();
    }
}
