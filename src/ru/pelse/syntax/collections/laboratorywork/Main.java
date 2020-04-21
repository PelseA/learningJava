package ru.pelse.syntax.collections.laboratorywork;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //буду сравнивать:
        //время создания LinkedList и ArrayList
        //время заполнения в цикле на 2,000,000 элементов
        //время добавления первого элемента, в начало коллекции, в конец коллекции
        //время получения первого, последнего, из конца

        //TODO на удаление еще не проверяла

        //для сравнения создадим две коллекции для String
        LinkedList<String> stringLinkedList = new LinkedList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        String testElement = "test string";
        // 2.0. сравнение времени добавления первого элемента
        long startTime1 = System.nanoTime();
        {
            stringLinkedList.addFirst(testElement);
        }
        long time1 = System.nanoTime() - startTime1;

        long startTime2 = System.nanoTime();
        {
            stringArrayList.add(0, testElement);
        }
        long time2 = System.nanoTime() - startTime2;

        System.out.println("дбавление первого элемента для LinkedList: " + time1); // 8300 | 9800 | 6400 | 9300
        System.out.println("добавление на нулевой индекс для ArrayList: " + time2); // 14100 | 12800 | 8600 | 14000

        //Заполнение коллекции в цикле
        //У нас есть две коллекции имеющие элемент под индексом 0 (для HashLinked - единственный)
        //
        //Предположу, что быстрее сработает LinkedList
        //из-за того, что ArrayList будет пересоздавать внутренний массив каждый раз при нехватке места
        //не буду создавать новые строки, так как допускается хранение одинаковых значений
        /*long startTime11 = System.nanoTime();
        {
            for (int i = 1; i <= 900000; i++) {
                stringLinkedList.add(i, testElement);
            }
        }
        long time11 = System.nanoTime() - startTime11;

        long startTime22 = System.nanoTime();
        {
            for (int i = 1; i <= 900000; i++) {
                stringArrayList.add(i, testElement);
            }
        }
        long time22 = System.nanoTime() - startTime22;

        System.out.println("для LinkedList: " + time11); // 17,229,400 | 17,213,300 | 16,367,500
        System.out.println("для ArrayList: " + time22); // 18,217,500 | 18,685,399 | 15,842,500*/
        //Вывод: мое предположение неверно

        //поменяю начальные данные: у нас обе коллекции пустые
        LinkedList<String> stringLinkedList2;
        ArrayList<String> stringArrayList2;
        //1. Сравниваю время создания коллекции
        //предположу, что LinkedList создается быстрее, т к ему нужно создать один узел с null,
        // а ArrayList нужно создать массив размером 10
        long startTime001 = System.nanoTime();
        {
            stringLinkedList2 = new LinkedList<>();
        }
        long time001 = System.nanoTime() - startTime001;

        long startTime002 = System.nanoTime();
        {
            stringArrayList2 = new ArrayList<>();
        }
        long time002 = System.nanoTime() - startTime002;

        System.out.println("для LinkedList: " + time001); // 33401 | 32499  | 90800 | 37400  | 28400
        System.out.println("для ArrayList: " + time002); // 109000 | 126800 | 87199 | 145600 | 114200
        //вывод: предположение верно: LinkedList с пустым конструктором создается быстрее, чем
        // ArrayList с пустым конструктором

        //2. заполнение в цикле начиная с нулевого индекса(узла - для LinkedList)
        long startTime111 = System.nanoTime();
        {
            for (int i = 0; i <= 2000000; i++) {
                stringLinkedList2.add(i, testElement);
            }
        }
        long time111 = System.nanoTime() - startTime111;

        long startTime222 = System.nanoTime();
        {
            for (int i = 0; i <= 2000000; i++) {
                stringArrayList2.add(i, testElement);
            }
        }
        long time222 = System.nanoTime() - startTime222;

        System.out.println("заполнение в цикле LinkedList: " + time111); // 99,133,500 | 103,146,501 | 93,383,100 | 94,932,701
        System.out.println("заполнение в цикле ArrayList: " + time222); // 98,137,400 | 102,603,900 | 64,626,900 | 68,074,501
        //вывод: ArrayList заполняется в цикле немного быстрее

        // 2.1. сравнение времени добавления на позицию 3000
        long startTime1_1 = System.nanoTime();
        {
            stringLinkedList2.add(3000, null);
        }
        long time1_1 = System.nanoTime() - startTime1_1;

        long startTime2_1 = System.nanoTime();
        {
            stringArrayList2.add(3000, null);
        }
        long time2_1 = System.nanoTime() - startTime2_1;
        //предположу, что LinkedList добавит элемент быстрее, т к ему не нужно передвигать все остальные элементы,
        // а только установить связи

        System.out.println("дбавление 3001 элемента для LinkedList: " + time1_1); // 55,300 | 61,900
        System.out.println("добавление на индекс 3000 для ArrayList: " + time2_1); // 618,500 | 630,900
        // Вывод: существенно быстрее работает LinkedList

        // 2.2. сравнение времени добавления элемента на позицию 1670000
        long startTime1_2 = System.nanoTime();
        {
            stringLinkedList2.add(1670000, null);
        }
        long time1_2 = System.nanoTime() - startTime1_2;

        long startTime2_2 = System.nanoTime();
        {
            stringArrayList2.add(1670000, null);
        }
        long time2_2 = System.nanoTime() - startTime2_2;
        //предположу, что время выполнения будет примерно одинаковым

        System.out.println("дбавление 1670001 элемента для LinkedList: " + time1_2); // 3,355,900 | 2,633,500 | 2,410,400
        System.out.println("добавление на индекс 1670000 для ArrayList: " + time2_2); // 133,400 | 95,500 | 98,300
        // Вывод: такого я не ожидала! Если в конец ArrayList добавлять элемент, то это значительно быстрее,
        // чем добавление в конец LinkedList

        //получение элементов
        //3. Получение первого элемента
        //предположу, что LinkedList всегда работает быстрее при получении первого элемента нежели ArrayList
        //тк ArrayList будет получать длину массива,чтобы индекс был в пределах
        long startTime1110 = System.nanoTime();
        {
            stringLinkedList2.getFirst();
        }
        long time1110 = System.nanoTime() - startTime1110;

        long startTime1111 = System.nanoTime();
        {
            stringLinkedList2.get(0);
        }
        long time1111 = System.nanoTime() - startTime1111;

        long startTime2222 = System.nanoTime();
        {
            stringArrayList2.get(0);
        }
        long time2222 = System.nanoTime() - startTime2222;

        System.out.println("для LinkedList getFirst: " + time1110); // 8500 | 7300 | 9400
        System.out.println("для LinkedList: " + time1111); //4299 | 8100 | 3999 | 4800 | 9399
        System.out.println("для ArrayList: " + time2222); // 3201 | 3899 | 3201 | 3599 | 4201
        //вывод: мое предположение снова неверно: ArrayList получает первый элемент быстрее

        //4. получение последнего элемента
        long startTime11111 = System.nanoTime();
        {
            stringLinkedList2.getLast();
        }
        long time11111 = System.nanoTime() - startTime11111;

        long startTime22222 = System.nanoTime();
        {
            stringArrayList2.get(2000002);
        }
        long time22222 = System.nanoTime() - startTime22222;

        System.out.println("получение последнего для LinkedList: " + time11111); // 2900 | 2900 | 2000
        System.out.println("получение последнего для ArrayList: " + time22222);  // 800 | 500 | 400

        //5.6.7.8.9.получение элемента из середины (первой половины, второй половины...)
        long startTime01 = System.nanoTime();
        {
            stringLinkedList2.get(1799999);
        }
        long time01 = System.nanoTime() - startTime01;

        long startTime02 = System.nanoTime();
        {
            stringArrayList2.get(1799999);
        }
        long time02 = System.nanoTime() - startTime02;

        System.out.println("для LinkedList: " + time01); // 5,155,399 | 5,206,400 | 5,348,700
        System.out.println("для ArrayList: " + time02); //  3701      | 2599      | 2900

        //Выводы пока рано делать, но наблюдения такие:
        // 1. создание коллекции с пустым конструктором:
        // LinkedList значительно быстрее чем ArrayList
        // 2.0 добавление одного элемента на нулевой индекс / первый узел
        // первый элемент в LinkedList добавляется быстрее
        // 2. заполнение в цикле начиная с нулевого индекса(узла) (кол-во элементов 2,000,000)
        // ArrayList заполняется в цикле немного быстрее
        // 2.1. сравнение времени добавления на позицию 3000
        // Добавление в начало коллекции существенно быстрее работает LinkedList
        // 2.2. сравнение времени добавления элемента на позицию 1670000
        // Добавление конец ArrayList значительно быстрее, чем добавление в конец LinkedList
        // 3. получение первого элемента
        // ArrayList получает первый элемент быстрее
        // 4. получение последнего элемента
        // ArrayList получает последний элемент быстрее
        // 5. получение элемента из середины
        // ArrayList получает элемент из середины значительно быстрее
        // 6. получение серединого элемента из первой половины
        // ArrayList получает элемент из середины первой половины значительно быстрее (2600 против 2913000)
        // 7. получение серединого элемента из второй половины
        // ArrayList получает элемент из середины второй половины значительно быстрее (3101 против 3113100)
        // 8. получение элемента под индексом 5 (узла 5)
        // ArrayList получает элемент значительно быстрее (300 против 1700)
        // 9. получение элемента под индексом 1,799,999 (узла 1,799,999)
        // ArrayList получает элемент значительно быстрее (4900 против 1409500)

    }

    //задумка вызвать метод в методе... не поняла, как при использовании в Main туда передать метод
    //передавала в фигурных скобках, но это не работает
    static long runTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        return System.nanoTime() - startTime;
    }


}
