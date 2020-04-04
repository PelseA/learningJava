package datetimetask;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
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
        /*Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
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
    }
}
