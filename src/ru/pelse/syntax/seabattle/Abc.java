package ru.pelse.syntax.seabattle;

public enum Abc {
    A(0, 'a'), B(1, 'b'), C(2, 'c'),
    D(3, 'd'), E(4, 'e'), F(5, 'f'),
    G(6, 'g'), H(7, 'h'), I(8, 'i'),
    J(9, 'j'), K(10, 'k'), L(11, 'l'),
    M(12, 'm'), N(13, 'n'), O(14, 'o'),
    P(15, 'p'), Q(16, 'q'), R(17, 'r'),
    S(18, 's'), T(19, 't'), U(20, 'u'),
    V(21, 'v'), W(22, 'w'), X(23, 'x'),
    Y(24, 'y'), Z(25, 'z');

    private final int number;
    private final char letter;

    Abc(int number, char letter) {
        this.number = number;
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

}
