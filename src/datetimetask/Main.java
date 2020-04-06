package datetimetask;

import datetimetask.lessonplanning.PlanLessons;
import datetimetask.lessonplanning.Planning;
import datetimetask.workshifts.WorkShift;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /*Задача: Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
        Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).
        Время в пути Сидней -  Хьюстон - 15 часов 35 минут
        Время ожидания в аэропорту Хьюстона - 1 час
        Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
        Время ожидания в аэропорту Вашингтона - 1 час 10 минут
        Время в пути Вашингтон - Оттава - 1 час 40 минут
        Вывести в консоль:
        Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
        Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
        Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)
        Часовые пояса:
        Сидней - Australia/Sydney
        Хьюстон - America/Chicago
        Вашингтон - America/New_York
        Оттава - America/Toronto*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        LocalDateTime sydneyTime = LocalDateTime.of(2020, Month.JUNE, 16, 19, 0);
        ZonedDateTime sydneyTimeLocal = sydneyTime.atZone(ZoneId.of("Australia/Sydney"));
        //прилетаем в Хьюстон
        ZonedDateTime arrivalInHouston = sydneyTimeLocal.plusHours(15).plusMinutes(35);
        ZonedDateTime departureFromHouston = arrivalInHouston.plusHours(1);
        ZonedDateTime localTimeHouston = departureFromHouston.withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println("Время вылета из аэропорта Хьюстона: " + localTimeHouston.format(formatter));
        ZonedDateTime arrivalInWashington = departureFromHouston.plusHours(2).plusMinutes(49);
        ZonedDateTime departureFromWashington = arrivalInWashington.plusHours(1).plusMinutes(10);
        ZonedDateTime localTimeWashington = departureFromWashington.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Время вылета из аэропорта Вашингтона: " + localTimeWashington.format(formatter));
        ZonedDateTime arrivalInOttawa = departureFromWashington.plusHours(1).plusMinutes(40);
        ZonedDateTime localTimeOttawa = arrivalInOttawa.withZoneSameInstant(ZoneId.of("America/Toronto"));
        System.out.println("Время прибытия в Оттаву " + localTimeOttawa.format(formatter));

        /*Задача 1. Есть три рабочие смены :
            с 7:00 до 15:00
            с 15:00 до 23:00
            с 23:00 до 7:00
        Определить, какая сейчас смена (относительно текущего времени) */
        WorkShift workShift = new WorkShift();
        workShift.getShiftByCurrentTime();

        /* Задача 2. Допустим,  занятия закончатся 20 июня 2020 года.
        Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?*/
        PlanLessons planLessons = new PlanLessons();
        LocalDate futureDay = LocalDate.of(2020, Month.JUNE, 20);
        System.out.println("Количество занятий до "+ futureDay + " "
                + planLessons.GetNumberOfRemainingLessons(LocalDate.now(), futureDay,
                DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY));

    }
}
