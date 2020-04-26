package ru.pelse.syntax.maps;

import java.text.DecimalFormat;
import java.util.*;

public class TextHandler {
    // 4.1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
    static public int repeatingWord(String word, String text) {
        String[] textSplit = text.split(" ");
        String[] lowerText = new String[textSplit.length];
        for (int i = 0; i < textSplit.length; i++) {
            if (lowerText[i] == null) lowerText[i] = textSplit[i].toLowerCase();
        }
        ArrayList<String> textToList = new ArrayList<>(Arrays.asList(lowerText));
        return Collections.frequency(textToList, word.toLowerCase());
    }

    // 4.2. написать метод, который собирает все слова в группы по количеству букв:
    // например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    static public HashMap<Integer, HashSet<String>> groupByWordLength(String text) {
        HashMap<Integer, HashSet<String>> group = new HashMap<>();
        HashSet<String> words;
        String[] textSplit = text.split(" ");
        for (String word : textSplit) {
            words = new HashSet<>();
            if (!group.containsKey(word.length())) {
                words.add(word.toLowerCase());
                group.put(word.length(), words);
            } else {
                group.get(word.length()).add(word.toLowerCase());
            }
        }
        return group;
    }

    // 4.3. написать метод, который выводит в консоль топ 10 самых частых слов
    // 2. дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов в списке
    // в виде Map<String, Integer>, где String - слово и Integer - количество повторений

    //todo 4.3. не дописан
    static public Map<String, Integer> getRepeatingWords(List<String> words) {
        Map<String, Integer> repeatingWordsMap = new HashMap<>();
        for (String word : words) {
            int count = 1;
            for (String w : words) {
                if (word.equals(w)) {
                    count++;
                }
            }
            repeatingWordsMap.put(word, count-1);
        }
        return repeatingWordsMap;
    }



    // 4.4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы
    static public HashMap<Character, String> frequencyLetters(String text) {
        String textWithoutSpaces = text.replaceAll(" ", "");
        char[] letters = textWithoutSpaces.toCharArray();
        int countLetters = letters.length;
        for (int k = 0; k < countLetters; k++) {
            letters[k] = Character.toLowerCase(letters[k]);
        }
        HashMap<Character, String> freqLetters = new HashMap<>();
        int i = 0;
        while (i < countLetters) {
            int count = 0;
            for (char letter : letters) {
                if (letters[i] == letter) count++;
            }
            System.out.println(letters[i]);
            float percent = (float)count * 100 / countLetters;
            freqLetters.put(letters[i], percent + "%");
            i++;
        }
        return  freqLetters;
    }
}
