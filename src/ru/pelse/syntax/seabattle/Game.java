package ru.pelse.syntax.seabattle;

public class Game {
    public FieldGenerator fieldGenerator;
    public PlayerActionHandler actionHandler;
    public void startGame(int fieldSize) throws IllegalArgumentException {
        if(fieldSize < 8 || fieldSize > 26) { //26 symbols in english alphabet
            throw new IllegalArgumentException("The size must be more than or equal to 8 and less than or equal to 26");
        }
        fieldGenerator = new FieldGenerator(fieldSize);
        fieldGenerator.positionShip(fieldGenerator.getField(), 4);
        fieldGenerator.positionShip(fieldGenerator.getField(), 3);
        fieldGenerator.positionShip(fieldGenerator.getField(), 3);
        fieldGenerator.positionShip(fieldGenerator.getField(), 2);
        fieldGenerator.positionShip(fieldGenerator.getField(), 2);
        fieldGenerator.positionShip(fieldGenerator.getField(), 2);
        fieldGenerator.positionShip(fieldGenerator.getField(), 1);
        fieldGenerator.positionShip(fieldGenerator.getField(), 1);
        fieldGenerator.positionShip(fieldGenerator.getField(), 1);
        fieldGenerator.positionShip(fieldGenerator.getField(), 1);
        fieldGenerator.displayFieldInConsole(fieldGenerator.getField());
        actionHandler = new PlayerActionHandler(fieldGenerator);
        actionHandler.tryAttack();
    }




}
