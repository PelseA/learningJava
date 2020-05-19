package ru.pelse.syntax.maps;

import java.util.*;
import java.util.stream.Collectors;

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

        // return Collections.frequency(Arrays.asList(text.toLowerCase().split(" ")),word.toLowerCase());
    }

    // 4.2. написать метод, который собирает все слова в группы по количеству букв:
    // например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    static public HashMap<Integer, HashSet<String>> groupByWordLength(String text) {
        HashMap<Integer, HashSet<String>> group = new HashMap<>();
        HashSet<String> words;
        String[] textSplit = text.split(" ");
        for (String word : textSplit) {
            if (!group.containsKey(word.length())) {
                words = new HashSet<>();
                words.add(word.toLowerCase());
                group.put(word.length(), words);
            } else {
                group.get(word.length()).add(word.toLowerCase());
            }
            // 1=[a], 2=[as, be, at, in, by, of, is, it, to, on], 3=[the, web, and, use, now, for, its, has], 4=[here, over, fact,
            // 1=[a], 2=[as, be, at, in, by, of, is, it, to, on], 3=[the, web, and, use, now, for, its, has], 4=[here, over, fact, will, like
        }
        return group;
    }

    // 4.3. написать метод, который выводит в консоль топ 10 самых частых слов
    // 2. дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов в списке
    // в виде Map<String, Integer>, где String - слово и Integer - количество повторений

    static public Map<String, Integer> getTopRepeatingWords(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = 1;
            for (String w : words) {
                if (word.equalsIgnoreCase(w)) {
                    count++;
                }
            }
            map.put(word.toLowerCase(), count - 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // 4.4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы
    static public void frequencyLetters(String processedText) {
        String text = processedText.toLowerCase()
                .replaceAll("\\p{P}", ""); //убрали пунктуацию

        int countCharacters = text.length();
        text = text.replaceAll("[^a-z]", ""); //удалил все нелатинские
        Map<Character, Integer> frequentCharacters = new TreeMap<>();
        for (Character character : text.toCharArray()) {
            if (frequentCharacters.containsKey(character))
                frequentCharacters.replace(character, frequentCharacters.get(character) + 1);
            else frequentCharacters.put(character, 1);
        }
        System.out.println("Процент латинских букв в тексте: ");
        System.out.println("всего букв в тексте " + countCharacters);
        Set<Map.Entry<Character, Integer>> frequentCharactersSet = frequentCharacters.entrySet();
        for (Map.Entry<Character, Integer> character : frequentCharactersSet) {
            System.out.print(character.getKey() + " встретилась в тексте " + character.getValue()
                    + " раз, что составляет " +
                    + (character.getValue().floatValue() / countCharacters * 100) + " % \n");
        }
    }
}
