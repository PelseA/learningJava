package ru.pelse.syntax.multithreading.cafe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Drink {
    COLA, TEA, COFFEE, MILKSHAKE, WATER, JUICE, BEER;

    private static final List<Drink> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Drink randomDrink()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
