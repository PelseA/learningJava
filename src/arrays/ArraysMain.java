package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysMain {
    public static void main(String[] args) {
        //1. Найти наибольший общий делитель (НОД) двух чисел
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        int minNumber = Math.min(a, b); // a < b ? a  : b;
        while (minNumber >= 1) {
            if(a % minNumber == 0 && b % minNumber == 0) {
                System.out.println("НОД для чисел " + a + " и " + b + " = " + minNumber);
                break;
            }
            minNumber--;
        }

        //2. Дан массив целых чисел. Массив не отсортирован, числа могут повторяться.
        // Необходимо найти в данном массиве такие два числа n и m, чтобы их сумма была равна 7.
        // Например, 2 + 5 = 7, 6 + 1 = 7, -2 + 9 = 7. Постарайтесь решить задачу наиболее оптимальным способом
        int[] arr = {4, 3, 8, 1, 2, -3, -4, 5, 6, -1, 0, 12, 11};
        int sum = 7, n, m;
        String string = "Сумма следующих двух чисел равна 7: ";
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    n = arr[i];
                    m = arr[j];
                    System.out.println(string + n + " и " + m);
                }
                if(arr[i] + arr[j] > sum || arr[i] == sum) break;
            }
        }

        //3. Заполните массив на N элементов случайными числами и выведите максимальное,
        // минимальное и среднее значение.
        System.out.println("Задайте количество элементов массива");
        int amount = scanner.nextInt();
        int[] randomArr = new int[amount];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(randomArr);
        System.out.println("Минимальное значение " + randomArr[0]);
        int last = randomArr.length-1;
        System.out.println("Максимальне значение " + randomArr[last]);
        int medium = (randomArr.length-1) / 2;
        if (randomArr.length %2 == 0) {
            System.out.println("Средние значения (посередине массива) " + randomArr[medium] + " и " + randomArr[medium+1]);
        } else {
            System.out.println("Среднее значение (посередине массива) " + randomArr[medium]);
        }
        int summa = 0;
        for (int elem: randomArr) {
            summa = summa + elem;
        }
        medium = summa / 2;
        int flag = 0;
        for (int elem: randomArr) {
            if(elem == medium) {
                flag = 1;
                System.out.println("Среднее арифметическое значение в массиве " + elem);
            }
        }
        if (flag == 0) {
            System.out.println("Среднего арифметического значения в массиве нет");
        }

        //4. Пользователь вводит с клавиатуры натуральное число большее 3,
        // которое сохраняется в переменную n. Если пользователь ввёл не подходящее число,
        // то программа должна просить пользователя повторить ввод. Создать массив из n случайных
        // целых чисел из отрезка [0;n] и вывести его на экран. Создать второй массив только из чётных
        // элементов первого массива, если они там есть, и вывести его в консоль
        System.out.println("Введите целое число больше 3");
        n = scanner.nextInt();
        while (n <= 3) {
            System.out.println("Введите целое число БОЛЬШЕ 3");
            n = scanner.nextInt();
        }
        int[] arr1 = new int[n];
        int count = 0, rand;
        for (int i = 0; i < arr1.length; i++) {
            rand = (int) (Math.random() * (n+1));
            arr1[i] = rand;
            if (rand %2 == 0) {
                count++;
            }
        }
        System.out.println("Случайный массив " + Arrays.toString(arr1));
        int[] newArr = new int[count];
        for (int i = 0, j = 0; i < arr1.length && j < newArr.length; i++, j++) {
            if (arr1[i] %2 != 0) j = j - 1;
            else newArr[j] = arr1[i];
        }
        System.out.println("Массив четных чисел " + Arrays.toString(newArr));

        //5. Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых
        // чисел из отрезка [-99;99]. Вывести массив в консоль. После на отдельной строке
        // вывести в консоль значение максимального элемента этого массива.
        int[][] array = new int[5][8];
        int random, currentMax = -99;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                random = (int) (Math.random() * (99*2+1)) - 99;
                array[i][j] = random;
                if(random > currentMax) {
                    currentMax = random;
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("Максимальное значение двумерного массива " + currentMax);

    }
}
