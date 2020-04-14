package ru.pelse.syntax.enumtask.employee;

public enum Position {
    DEVELOPER("d"), MANAGER("m"), TESTER("t"), INTERN("i");

    private String firstLetter;

    Position(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
