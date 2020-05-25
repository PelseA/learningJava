package ru.pelse.syntax.multithreading.cafe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum  Meal {
    BEEF, PORK, EGGS, BURGER, SALAD, SOUP, PANCAKES, FISH;

    private static final List<Meal> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Meal randomMeal()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
