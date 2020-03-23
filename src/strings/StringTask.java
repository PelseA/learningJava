package strings;

import java.util.Arrays;

public class StringTask {
    public static void main(String[] args) {
        //Задача 1. Даны 2 слова, состоящие из четного числа букв. Получить слово состоящее из
        //первой половины первого слова и второй половины второго слова.
        String word1 = "cucumbers";
        String word2 = "foreheads";
        word1 = word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
        System.out.println(word1); //cucuheads
        //Задача 2. Найдите самое длинное слово в предложении, при условии,
        //что в предложении все слова разной длины.
        String sentence = "С печальной Таней наш приятель.";
        String[] strings = sentence.split("\\s|,\\s|\\.");
        int longest = 1;
        String longestWord = "";
        for (String word : strings) {
            if (word.length() > longest) {
                longest = word.length();
                longestWord = word;
            }
        }
        System.out.println(longestWord);
        //Задача 3. Имеются две строки. Найти количество вхождений одной строки в другую.
        String str1 = "parallelogram";
        String str2 = "ra";
        int entries = 0;
        String[] parts = str1.split("ra");
        if (parts.length > 0) entries = parts.length - 1;
        //если вхождение в конце строки оно не будет в массиве после split поэтому делаю следующее
        StringBuilder sb = new StringBuilder();
        String endOfWord = sb.append(str1).delete(0, str1.length() - str2.length()).toString();
        if (endOfWord.equals(str2)) entries++;
        System.out.println(entries);

        //Задача 4. Написать функцию, которая проверяет, является ли строка палиндромом.
        //Палиндром читается в обе стороны одинаково.
        String stroka = "А по морде ведром?- опа!";
        System.out.println(isPalindrome(stroka));

        //5. Даны два слова и словарь (массив слов). Необходимо найти алгоритм превращения
        // в другое, меняя за один шаг одну букву, причем каждое новое слово должно быть в словаре
        // (массиве слов). Например,даны слова "hit" и "cog" и словарь(массив слов)
        // ["hot", "dot", "dog", "log", "lot"]. Один из вариантов цепочки: "hit"->"hot"->"dot"->"dog"->"cog".
        //6. Пользователь вводит названия городов через пробел. Вы их присваиваете переменной.
        // Переставьте названия так, чтобы они были упорядочены по алфавиту.
        String cities = "Донецк Саратов Сарапул Анапа Ана Белгород Сар Анадырь";
        String sorted = sortAbc(cities);
        System.out.println("result " + sorted);
    }

    private static String sortAbc(String str) {
        String[] strABC = str.split("\\s");
        int minLength;
        String temp;
        int flag = 0;
        int j;
        for (int i = 0; i < strABC.length - 1; i++) {
            minLength = Math.min(strABC[i].length(), strABC[i+1].length());
            j = 0;
            while(j < minLength && strABC[i].charAt(j) == strABC[i+1].charAt(j)) {
                j++;
            }
//            System.out.println(strABC[i]);
//            System.out.println(strABC[i+1]);
//            System.out.println("j " + j);
            if(strABC[i].length() == minLength) {
                continue;
            }
            if(strABC[i+1].length() == minLength && strABC[i].length() > minLength) {
                temp = strABC[i+1];
                strABC[i+1] = strABC[i];
                strABC[i] = temp;
                flag++;
            }
            else if (strABC[i].charAt(j) > strABC[i+1].charAt(j)) {
                temp = strABC[i+1];
                strABC[i+1] = strABC[i];
                strABC[i] = temp;
                flag++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        while (k < strABC.length) {
            stringBuilder.append(strABC[k]).append(" ");
            k++;
        }
        String sortedStr = stringBuilder.toString();
        if (flag == 0) {
            return sortedStr;
        } else return sortAbc(sortedStr);
    }

    private static boolean isPalindrome(String str) {
        str = str.replaceAll(" ", "")
                .replaceAll(",", "")
                .replaceAll("-", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .toLowerCase();
        String forCompare = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            forCompare = str.charAt(i) + forCompare;
            forCompare = sb.append(forCompare).toString();
            sb.setLength(0);
        }
        System.out.println(forCompare);
        return str.equals(forCompare);
    }


}
