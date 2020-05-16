package ru.pelse.syntax.stream;

import ru.pelse.syntax.server.messages.Server;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 по частоте встречаемости слов

        Properties properties = new Properties();
        try (InputStream input = Server.class.getClassLoader()
                .getResourceAsStream("path.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String FILE_NAME = properties.getProperty("stream.tenwords");
        Map<String, Long> countWords;

        // = читаем из файла в stream
        Stream<String> linesStream = Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        // сделать stream параллельным
        // обработать каждый элемент: убрать пробелы, привести к нижнему регистру
        // создать новый stream: массив слов - flatMap
        Set<Map.Entry<String, Long>> entries = linesStream
                .parallel()
                .flatMap(oneLine -> Stream.of(oneLine.split(" +")))
                .map(string -> string.toLowerCase().trim())
                .map(word->word.replaceAll("\\p{P}", "")) //убрали пунктуацию
                // собрать в map: слово - количество
                .collect(Collectors.groupingBy(String::new, Collectors.counting()))
                // получить entrySet() терминальная операция
                .entrySet();

        // снова создать параллельный stream
        // сортировать по значениям
        // получить первые 10 элементов
        // собирать мапу; терминальная операция
        countWords = entries.stream()
                .parallel()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
        System.out.println(countWords);

    }

}
