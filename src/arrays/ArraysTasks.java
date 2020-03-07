package arrays;

import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        // Задача 1
        //Создайте массив из всех чётных чисел от 2 до 20
        //и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2).
        int[] arr = new int[20 / 2];
        for (int i = 2, j = 0; i <= 20 && j < arr.length; i += 2, j++) {
            arr[j] = i;
        }
        int k = arr.length - 1;
        while (k >= 0) {
            System.out.println(arr[k]);
            k = k - 1;
        }

        // Задача 2
        //Создайте массив из 15 случайных целых чисел из отрезка [0;9].
        //Выведите массив в консоль.
        //Подсчитайте сколько в массиве чётных элементов и выведете это количество в консоль.
        int[] arr2 = new int[15];
        int value;
        int amount = 0;
        for (int i = 0; i < 15; i++) {
            value = (int) (Math.random() * 8) + 1;
            arr2[i] = value;
            if (value % 2 == 0) amount += 1;
        }
        System.out.println("В массиве " + Arrays.toString(arr2) + " " + amount + " четных чисел");

        // Задача 3
        //Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его в консоль.
        //Определить и вывести в консоль сообщение о том, является ли массив строго
        //возрастающей последовательностью.
        int[] arr3 = new int[4];
        int val;
        int currentVal = 0;
        String result = " является строго возрастающей последовательностью.";
        for (int i = 0; i < 4; i++) {
            val = (int) (Math.random() * (99 - 10)) + 10;
            arr3[i] = val;
            if (val > currentVal) {
                currentVal = val;
            } else {
                result = " НЕ является строго возрастающей последовательностью.";
            }
        }
        System.out.println("Массив " + Arrays.toString(arr3) + result);

        // Задача 4
        //Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
        //Определите какой элемент встречается в массиве чаще всего и выведите об этом в консоль.
        //Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.
        int[] arr4 = new int[11];
        int val1;
        int zero = 0, one = 0, minusOne = 0;
        for (int i = 0; i < 11; i++) {
            val1 = (int) (Math.random() * 3) - 1; // себе: *3 т.е. -1, 0 и 1 - это три элемента
            arr4[i] = val1;
            if (val1 == 0) zero += 1;
            if (val1 == 1) one += 1;
            if (val1 == -1) minusOne += 1;
        }
        System.out.println(Arrays.toString(arr4));
        if (zero != one && minusOne != zero && one != minusOne) {
            if (zero > one && zero > minusOne) {
                System.out.println("0 встречается чаще");
            } else if (one > zero && one > minusOne) {
                System.out.println("1 встречается чаще");
            } else System.out.println("-1 встречается чаще");
        }

        //МНОГОМЕРНЫЕ МАССИВЫ
        //Задача 1
        //Создать двумерный массив
        //из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].
        //Вывести массив в консоль.
        int[][] twoDimArr = new int[8][5];
        int ranNumber;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                ranNumber = (int) (Math.random() * (99 - 10)) + 10;
                twoDimArr[i][j] = ranNumber;
            }
        }
        System.out.println(Arrays.deepToString(twoDimArr));

        //Задача 2
        //Cоздать двумерный массив из 7 строк по 4 столбца в каждой из случайных целых чисел
        //из отрезка [-5;5]. Вывести массив в консоль.
        //Определить и вывести на экран индекс строки с наибольшим по модулю произведением элементов.
        //Если таких строк несколько, то вывести индекс первой встретившейся из них.
        int[][] twoDimArr2 = new int[7][4];
        int number;
        int mult = 0, currentMult = 1, index = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                number = (int) (Math.random() * 11) - 5;
                twoDimArr2[i][j] = number;
                currentMult *= number;
            }
            currentMult = currentMult < 0 ? currentMult * (-1) : currentMult;
            if (currentMult > mult) {
                index = i;
                mult = currentMult;
                currentMult = 0;
            }
        }
        System.out.println(Arrays.deepToString(twoDimArr2));
        System.out.println("Индекс строки с наибольшим по модулю произведением элементов: " + index);

        //Задача 3
        //Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел из отрезка [0;9].
        //Вывести массив в консоль.
        //Преобразовать массив таким образом, чтобы на первом месте в каждой строке стоял её наибольший элемент.
        //При этом изменять состав массива нельзя, а можно только переставлять элементы в рамках одной строки.
        //Порядок остальных элементов строки не имеет значения (т.е. можно соврешить только одну перестановку,
        //а можно отсортировать по убыванию каждую строку).
        //Вывести преобразованный массив в консоль.
        int[][] twoDimArr3 = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                number = (int) (Math.random() * 10); // себе: вместе с 0 получается 10 элементов
                twoDimArr3[i][j] = number;
            }
        }
        System.out.println(Arrays.deepToString(twoDimArr3));
        int save;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (twoDimArr3[i][0] < twoDimArr3[i][j]) {
                    save = twoDimArr3[i][0];
                    twoDimArr3[i][0] = twoDimArr3[i][j];
                    twoDimArr3[i][j] = save;
                }
            }
        }
        System.out.println(Arrays.deepToString(twoDimArr3));

    }
}
