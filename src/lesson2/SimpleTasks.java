package lesson2;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class SimpleTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        // Задача 1
        //В переменной n хранится натуральное трёхзначное число. Вывести в консоль сумму цифр числа n.
        while(true) {
            System.out.println("Введите трехзначное число");
            int number = sc.nextInt();
            int savedNumber = number;
            if (number == 0) break;
            if (number < 0) number = number * -1;
            if (number > 999 || number < 100) {
                System.out.println("Число не трехзначное");
                break;
            }
            for( ; number > 0; number /=10) {
                sum = number %10 + sum;
            }
            System.out.println("Сумма чисел числа " + savedNumber + " = " + sum);
            sum = 0;
        }

        // Задача 2
        // Проверить является ли целое число записанное в переменную n, чётным либо нечётным. Результат вывсети в консоль.
        int n = 93;
        if(n % 2 == 0) System.out.println("Число " + n + " четное");
        System.out.println("Число " + n + " нечетное");

        // Задача 3
        // Даны два целых числа n и m. Наименьшее из них сохранить в переменную res и вывести ее на экран.
        int m = 27;
        n = 3828;
        if (n < m) System.out.println("наименьшее число n = " + n);
        else if (n == m) System.out.println("числа равны");
        else System.out.println("Наименьшее число m = " + m);

        //Задача 4
        //Написать код, который будет проверять попало ли случайно сгенерированное целое число
        //из отрезка [5;122] в интервал (25;100) и выводить результат в консоль.
        //Примеры работы программы: "Число 113 не содержится в интервале (25,100)"
        int programNum = (int) (Math.random() * (122-25)) + 25;
        String res = (programNum > 100) ? " не содержится" : " содержится";
        System.out.println("Чисо " + programNum + res + " в интервале (25,100)");

        //Задача 5
        //Написать код, выводящий на экран случайно сгенерированное трёхзначное число и его наибольшую цифру.
        //Примеры работы программы: "В числе 208 наибольшая цифра 8"
        programNum = (int) (Math.random() * (999-100)) + 100;
        int saveNumber = programNum;
        int currentNumber;
        int a = 0;
        if(programNum >= 100 && programNum <= 999) {
            for( ; programNum > 0; programNum /= 10) {
                currentNumber = programNum %10;
                if(a < currentNumber) a = currentNumber;
            }
            System.out.println("В числе " + saveNumber + " наибольшая цифра " + a);
        }
        else System.out.println("Не трехзначное число");

        //Задача 6
        //Создайте программу, выводящую на экран все
        //четырёхзначные числа последовательности 1000 1003 1006 1009 1012 1015 ….
        for(int i = 1000; i < 1030; i += 3) { //условие  заменить на i < 10000
            System.out.println(i);
        }

        //Задача 9
        //Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
        for(int i = 2, numeration = 1; i >=2 && numeration <= 20; i *= 2, numeration++) {
            System.out.println(numeration + ". " + i);
        }

    }
}
