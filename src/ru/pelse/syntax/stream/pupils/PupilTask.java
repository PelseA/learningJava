package ru.pelse.syntax.stream.pupils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("Валя", Pupil.Gender.FEMALE, LocalDate.of(2012, 12, 6)));
        pupils.add(new Pupil("Дима", Pupil.Gender.MALE, LocalDate.of(2012, 3, 14)));
        pupils.add(new Pupil("Галя", Pupil.Gender.FEMALE, LocalDate.of(2012, 4, 22)));
        pupils.add(new Pupil("Коля", Pupil.Gender.MALE, LocalDate.of(2010, 2, 24)));
        pupils.add(new Pupil("Люда", Pupil.Gender.FEMALE, LocalDate.of(2010, 10, 12)));
        pupils.add(new Pupil("Дина", Pupil.Gender.FEMALE, LocalDate.of(2013, 12, 4)));
        pupils.add(new Pupil("Соня", Pupil.Gender.FEMALE, LocalDate.of(2011, 1, 31)));
        pupils.add(new Pupil("Петя", Pupil.Gender.MALE, LocalDate.of(2013, 12, 7)));
        pupils.add(new Pupil("Толя", Pupil.Gender.MALE, LocalDate.of(2012, 7, 27)));
        pupils.add(new Pupil("Настя", Pupil.Gender.FEMALE, LocalDate.of(2010, 8, 3)));
        pupils.add(new Pupil("Саша", Pupil.Gender.MALE, LocalDate.of(2012, 6, 17)));
        pupils.add(new Pupil("Лена", Pupil.Gender.FEMALE, LocalDate.of(2010, 1, 12)));
        pupils.add(new Pupil("Дима", Pupil.Gender.MALE, LocalDate.of(2011, 11, 19)));

        // Используя Stream API:
        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> divisionByGender = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(divisionByGender);

        // 2. Найти средний возраст учеников
        double averageAge = pupils.stream()
                .mapToInt(p -> Period.between(p.getBirth(), LocalDate.now()).getYears())
                .summaryStatistics()
                .getAverage();
        System.out.println("Средний возраст учеников: " + averageAge);

        // 3. Найти самого младшего ученика
        Optional<Pupil> youngerPupil = pupils.stream()
                .min(Comparator.comparingInt(p -> Period.between(p.getBirth(), LocalDate.now()).getYears()));

        System.out.println("самый младший ученик: " + youngerPupil);

        // 4. Найти самого старшего ученика
        Optional<Pupil> olderPupil = pupils.stream()
                .sorted((p1, p2) ->
                        Period.between(p2.getBirth(), LocalDate.now()).getYears() - Period.between(p1.getBirth(), LocalDate.now()).getYears())
                .findFirst(); //можно max как в примере с минимальным возрастом

        System.out.println("старший ученик: " + olderPupil);

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Pupil>> groupByYearBirth = pupils.stream()
                .collect(Collectors.groupingBy(p -> p.getBirth().getYear(),
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(groupByYearBirth);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}