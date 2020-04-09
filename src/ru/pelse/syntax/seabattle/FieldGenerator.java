package ru.pelse.syntax.seabattle;

import java.util.Arrays;

public class FieldGenerator {
    int[][] field;
    int[][] emptyField;

    public FieldGenerator(int size) {
        this.field = generateField(size);
        this.emptyField = generateField(size);
    }

    public int[][] getField() {
        return field;
    }

    public int[][] getEmptyField() {
        return emptyField;
    }

    int[][] generateField(int size) {
        return new int[size][size];
    }

    void positionShip(int[][] field, int countOfDecks) throws IllegalArgumentException {
        if (countOfDecks > field.length) {
            throw new IllegalArgumentException("The count of decks must not be more than field size.");
        }
        int direction = (int) (Math.random() * 2); // 1 - horizontal or 0 - vertical
        toPosition(direction, countOfDecks);
    }

    void fillSpaceAround(int direction, int startPosCell, int startPosRow, int countDecks) {
        if (direction == 1) {
            if (startPosCell > 0) {
                if (field[startPosRow][startPosCell - 1] == 0) field[startPosRow][startPosCell - 1] = 1;
                if (startPosRow > 0) {
                    if (field[startPosRow - 1][startPosCell - 1] == 0) field[startPosRow - 1][startPosCell - 1] = 1;
                }
                if (startPosRow < field.length - 1) {
                    if (field[startPosRow + 1][startPosCell - 1] == 0) field[startPosRow + 1][startPosCell - 1] = 1;
                }
            }
            if (startPosRow > 0) {
                for (int i = startPosCell; i < startPosCell + countDecks; i++) {
                    if (field[startPosRow - 1][i] == 0) field[startPosRow - 1][i] = 1;
                }
            }
            if (startPosRow < field.length - 1) {
                for (int i = startPosCell; i < startPosCell + countDecks; i++) {
                    if (field[startPosRow + 1][i] == 0) field[startPosRow + 1][i] = 1;
                }
            }
            if (startPosCell < field.length - countDecks) {
                if (field[startPosRow][startPosCell + countDecks] == 0)
                    field[startPosRow][startPosCell + countDecks] = 1;
                if (startPosRow > 0) {
                    if (field[startPosRow - 1][startPosCell + countDecks] == 0)
                        field[startPosRow - 1][startPosCell + countDecks] = 1;
                }
                if (startPosRow < field.length - 1) {
                    if (field[startPosRow + 1][startPosCell + countDecks] == 0)
                        field[startPosRow + 1][startPosCell + countDecks] = 1;
                }
            }
        } else {
            if (startPosRow > 0) {
                if (field[startPosRow - 1][startPosCell] == 0) field[startPosRow - 1][startPosCell] = 1;
                if (startPosCell > 0) {
                    if (field[startPosRow - 1][startPosCell - 1] == 0) field[startPosRow - 1][startPosCell - 1] = 1;
                }
                if (startPosCell < field.length - 1) {
                    if (field[startPosRow - 1][startPosCell + 1] == 0) field[startPosRow - 1][startPosCell + 1] = 1;
                }
            }
            if (startPosCell > 0) {
                for (int j = startPosRow; j < startPosRow + countDecks; j++) {
                    if (field[j][startPosCell - 1] == 0) field[j][startPosCell - 1] = 1;
                }
            }
            if (startPosCell < field.length - 1) {
                for (int j = startPosRow; j < startPosRow + countDecks; j++) {
                    if (field[j][startPosCell + 1] == 0) field[j][startPosCell + 1] = 1;
                }
            }
            if (startPosRow < field.length - countDecks) {
                if (field[startPosRow + countDecks][startPosCell] == 0)
                    field[startPosRow + countDecks][startPosCell] = 1;
                if (startPosCell > 0) {
                    if (field[startPosRow + countDecks][startPosCell - 1] == 0)
                        field[startPosRow + countDecks][startPosCell - 1] = 1;
                }
                if (startPosCell < field.length - 1) {
                    if (field[startPosRow + countDecks][startPosCell + 1] == 0)
                        field[startPosRow + countDecks][startPosCell + 1] = 1;
                }
            }
        }
    }

    void toPosition(int direction, int countOfDecks) {
        int startPosRow = field.length; //за пределами поля
        int startPosCell = field.length;

        if (direction == 1) {
            while (startPosCell > field.length - countOfDecks) {
                startPosCell = (int) (Math.random() * field.length);
            }
            startPosRow = (int) (Math.random() * field.length);
        } else {
            while (startPosRow > field.length - countOfDecks) {
                startPosRow = (int) (Math.random() * field.length);
            }
            startPosCell = (int) (Math.random() * field.length);
        }
        int empty = 0;
        int success = 0;
        if (direction == 0) {
            for (int i = startPosRow; i < countOfDecks + startPosRow; i++) {
                if (field[i][startPosCell] == 0) {
                    empty++;
                }
            }
            if (empty == countOfDecks) {
                for (int i = startPosRow; i < countOfDecks + startPosRow; i++) {
                    field[i][startPosCell] = 5;
                    success++;
                }

            }
        } else {
            for (int i = startPosCell; i < countOfDecks + startPosCell; i++) {
                if (field[startPosRow][i] == 0) {
                    empty++;
                }
            }
            if (empty == countOfDecks) {
                for (int i = startPosCell; i < countOfDecks + startPosCell; i++) {
                    field[startPosRow][i] = 5;
                    success++;
                }
            }
        }
        if (success != 0) {
            fillSpaceAround(direction, startPosCell, startPosRow, countOfDecks);
        } else {
            toPosition(direction, countOfDecks);
        }
    }


    void displayFieldInConsole(int[][] field) {
        for (int[] line : field) {
            System.out.println(Arrays.toString(line));
        }
    }
}
