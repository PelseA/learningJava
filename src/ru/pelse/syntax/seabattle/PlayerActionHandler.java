package ru.pelse.syntax.seabattle;

import java.util.Scanner;

public class PlayerActionHandler {
    public FieldGenerator fieldGenerator;
    public Scanner sc;
    int[][] field;
    int[][] emptyField;
    int deadShips = 10;

    public PlayerActionHandler(FieldGenerator fieldGenerator) {
        this.fieldGenerator = fieldGenerator;
        this.field = fieldGenerator.field;
        this.emptyField = fieldGenerator.emptyField;
        this.sc = new Scanner(System.in);
    }

    public void tryAttack() throws IllegalArgumentException {
        System.out.println("Attack! Use the latin alphabet and numbers. For example: " + randomExample(fieldGenerator.field.length));
        String attack = sc.nextLine().trim().replaceAll(" ", "");
        char letter = attack.charAt(0);
        int row = getNumberByChar(letter);
        if(row > field.length || row == -1) {
            throw new IllegalArgumentException("The letter must be in range from a to " + field.length);
        }
        int cell = Integer.parseInt(attack.substring(1));
        if(cell > field.length) {
            throw new IllegalArgumentException("The number must be in range from 1 to " + field.length);
        }
        checkTarget(row, cell-1);
    }

    protected void checkTarget(int row, int cell) {
        if(field[row][cell] == 5) {
            field[row][cell] = 7;
            if (checkSpaceAround(row, cell)) {
                deadShips--;
                System.out.println("Убил!");
            } else {
                System.out.println("Ранил");
            }
            emptyField[row][cell] = 5;
        } else {
            System.out.println("Промах =)");
            emptyField[row][cell] = 1;
        }
        fieldGenerator.displayFieldInConsole(emptyField);
        if(deadShips == 0) System.out.println("Игра окончена, вы уничтожили все корабли");
        else tryAttack();
    }

    private boolean checkSpaceAround(int row, int cell) {
        int spaceAround = 0;
        if(row > 0) {
            if(field[row-1][cell] == 5) spaceAround++;
        }
        if(row < field.length-1) {
            if(field[row+1][cell] == 5) spaceAround++;
        }
        if(cell > 0) {
            if (field[row][cell-1] == 5) spaceAround++;
        }
        if(cell < field.length-1) {
            if(field[row][cell+1] == 5) spaceAround++;
        }
        return spaceAround <= 0; //false- ранил; true - убил
    }

    protected String randomExample(int fieldSize) {
        int number = (int) (Math.random() * fieldSize + 1) - 1;
        String strNumber = Integer.toString(number);
        int letterInt = (int) (Math.random() * fieldSize);
        return Character.toString(getCharByNumber(letterInt)).concat(strNumber);
    }

    protected int getNumberByChar(char letter) {
        for (Abc item : Abc.values()) {
            if (item.getLetter() == letter) {
                return item.getNumber();
            }
        }
        return -1;
    }

    protected char getCharByNumber(int number) {
        for (Abc item : Abc.values()) {
            if (item.getNumber() == number) {
                return item.getLetter();
            }
        }
        return 0;
    }
}
