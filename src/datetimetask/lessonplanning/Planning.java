package datetimetask.lessonplanning;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract public class Planning {
    public long GetNumberOfRemainingLessons(LocalDate startDay, LocalDate LastLessonDate, DayOfWeek...days) {
        long between = ChronoUnit.DAYS.between(startDay, LastLessonDate);
        long count = 0;
        for (DayOfWeek day : days) {
            if (startDay.getDayOfWeek().equals(day)) {
                count++;
            }
        }
        for(long i = 1; i <= between; i++) {
            LocalDate nextDay = startDay.plusDays(1);
            startDay = nextDay;
            for (DayOfWeek day: days) {
                count = this.matchDay(nextDay, day, count);
            }
        }
        return count;
    }

    long matchDay(LocalDate checkDay, DayOfWeek day, long count) {
        if(checkDay.getDayOfWeek().equals(day)) {
            switch(checkDay.getDayOfWeek()) {
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                case SATURDAY:
                case SUNDAY:
                    count++; break;
            }
        }
        return count;
    }
}
