package strings;

import java.util.Arrays;

public class StringTask {
    public static void main(String[] args) {
        //Задача 1. Даны 2 слова, состоящие из четного числа букв. Получить слово состоящее из
        //первой половины первого слова и второй половины второго слова.
        String word1 = "cucumber";
        String word2 = "forehead";
        int length = word1.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        word2 = sb2.append(word2).delete(0, length/2).toString();
        word1 = sb1.append(word1).delete(length/2, length).append(word2).toString();
        System.out.println(word1); //cucuhead
        //Задача 2. Найдите самое длинное слово в предложении, при условии,
        //что в предложении все слова разной длины.
        String sentence = "С печальной Таней наш приятель.";
        String[] strings = sentence.split("\\s|,\\s|\\.");
        int longest = 1;
        String longestWord = "";
        for (String word: strings) {
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
        if(parts.length > 0) entries = parts.length - 1;
        //если вхождение в конце строки оно не будет в массиве после split поэтому делаю следующее
        StringBuilder sb = new StringBuilder();
        String endOfWord = sb.append(str1).delete(0, str1.length()-str2.length()).toString();
        if(endOfWord.equals(str2)) entries++;
        System.out.println(entries);

        //Задача 4. Написать функцию, которая проверяет, является ли строка палиндромом.
        //Палиндром читается в обе стороны одинаково.
        String stroka = "Venice";
        System.out.println(isPalindrome(stroka));

        //5. Даны два слова и словарь (массив слов). Необходимо найти алгоритм превращения
        // в другое, меняя за один шаг одну букву, причем каждое новое слово должно быть в словаре
        // (массиве слов). Например,даны слова "hit" и "cog" и словарь(массив слов)
        // ["hot", "dot", "dog", "log", "lot"]. Один из вариантов цепочки: "hit"->"hot"->"dot"->"dog"->"cog".
        //6. Пользователь вводит названия городов через пробел. Вы их присваиваете переменной.
        // Переставьте названия так, чтобы они были упорядочены по алфавиту.
    }
    private static boolean isPalindrome(String str) {
        int length = str.length();
        str = str.toLowerCase();
        String forCompare = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            forCompare = str.charAt(i) + forCompare;
            forCompare = sb.append(forCompare).toString();
            System.out.println(forCompare);
            sb.setLength(0);
        }
        return str.equals(forCompare);
    }

}
