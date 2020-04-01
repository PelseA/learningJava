package ru.pelse.syntax.training;

public class Porridge {
    public MainInterface someClass;

    public Porridge(MainInterface someClass) {
        this.someClass = someClass;
    }

    public  void cookPorridge(){
        if (someClass instanceof ImplemintationFirst) {
            //значит что-то делаем для этого класса
            System.out.println("Это экзмепляр класса " + someClass.getClass());
        }
        if (someClass instanceof ImplemintationSecond) {
            //тогда делаем что-то для этого класса
            System.out.println("Это экзмепляр класса " + someClass.getClass());
        }

    }


}
