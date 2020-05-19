package ru.pelse.syntax.maps;

import java.util.*;

public class MapTask {
    private static List<String> getPeopleByCity(Map<String, String> map, String city) {
        List<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) {
                logins.add(entry.getKey());
            }
        }
        return logins;
    }

    private static Map<String, Integer> getRepeatingWords(List<String> words) {
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            if (wordCounter.containsKey(word)) {
                wordCounter.replace(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }
        return wordCounter;
    }

    // 3. дана мапа (customerMap).
    // Написать метод, который принимает на вход аргументы int from и int to и возвращает новую мапу,
    // в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)
    private static Map<String, Customer> getCustomerInRange(HashMap<String, Customer> customers, int from, int to) {
        HashMap<String, Customer> customerMap = new HashMap<>();
        int order = 1;
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() < to) {
                customerMap.put(Integer.toString(order), entry.getValue());
                order = order + 1;
            }
        }
        return customerMap;
    }

    public static void main(String[] args) {
        // 1. написать статический метод, который приннимает на вход
        // мапу (firstTaskMap) и город city
        // и формирует список (List) логинов, которые соответствуют переданному городу
        HashMap<String, String> firstTaskMap = new HashMap<>();

        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";

        System.out.println(getPeopleByCity(firstTaskMap, city));

        // 2. дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов в списке
        // в виде Map<String, Integer>, где String - слово и Integer - количество повторений
        String s = "May, dinosaur, whale, may, frog, tactful, brave, people, indistinguishable, supernatural, dog, frog, " +
                "August, tremendous, desired, frog, Monday, apple, July, whale, supernatural, polish, save, main, aboard, " +
                "dinosaur, tremendous, reflect, west, frog, brave, artsy, whale, desired, benevolent, major, whale, doubt, " +
                "brave, among, August, people, July, frog, July, may, development, developer, system, supernatural, math, " +
                "benevolent, obsessive, major, whale, doubt, frog, brave, among, August, people, July, tactful, desired, " +
                "tactful, system, tremendous, frog, benevolent, System, energy, begging, artsy, vine, south, brave, july, " +
                "embarrassed, supernatural, math, geometry, polish, frog, independent, tactful, supernatural, brave, people, " +
                "independent, tactful, frog, indistinguishable, artsy, desired, Monday, tremendous, among, whale, developer, " +
                "apple, whale, apple, dinosaur, tremendous, affective, benevolent, dinosaur, desired, system, elementary, " +
                "tremendous, benevolent, tremendous, System, development, frog, energy, surgery, surgery, benevolent, desired, " +
                "benevolent, development, frog, doubt, whale, doubt, brave, supernatural, among, August, people, math, energy, " +
                "obsessive, major, whale, doubt, brave, supernatural, among, August, people, July, tactful, space, may, " +
                "interrupt, unmindful, ordinary, game, supernatural, tremendous, benevolent, tremendous, System, energy, " +
                "surgery, frog, major, whale, doubt, frog, brave, supernatural, development, dog, tactful, frog, dog";
        List<String> words = new ArrayList<>();
        String[] arr = s.split(", ");
        Collections.addAll(words, arr);

        System.out.println("Повторяющиеся слова " + getRepeatingWords(words));

        // 3.
        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(getCustomerInRange(customerMap, 20, 50));

        // 4. Задания по тексту (text). На каждый пункт - минимум один метод:
        // 4.1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        // 4.2. написать метод, который собирает все слова в группы по количеству букв:
        // например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        // 4.3. написать метод, который выводит в консоль топ 10 самых частых слов
        // 4.4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        String text = "Русские буквы It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like"; // !!! в тексте содержатся только буквы и пробельные символы !!!

        // 4.1.
        String testString = "Lorem";
        System.out.println("Слово " + testString + " встречается в тексте " + TextHandler.repeatingWord(testString, text) + " раз(а)");
        // 4.2.
        System.out.println(TextHandler.groupByWordLength(text));
        // 4.3.
        System.out.println("Топ 10 самых частых слов в списке: ");
        System.out.println(TextHandler.getTopRepeatingWords(words));
        // 4.4.
        TextHandler.frequencyLetters(text);

    }

}
