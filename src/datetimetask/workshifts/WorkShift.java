package datetimetask.workshifts;

import java.time.LocalTime;

public class WorkShift implements ShiftActivities{

    @Override
    public void getShiftByCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isAfter(Shift.MORNING.getStart()) && currentTime.isBefore(Shift.MORNING.getFinish())) {
            System.out.println("Работает утренняя смена");
            return;
        }
        if(currentTime.isAfter(Shift.EVENING.getStart()) && currentTime.isBefore(Shift.EVENING.getFinish())) {
            System.out.println("Работает вечерняя смена");
            return;
        }
        if(currentTime.isAfter(Shift.NIGHT.getStart()) && currentTime.isBefore(Shift.NIGHT.getFinish())) {
            System.out.println("Работает ночная смена");
            return;
        }
        System.out.println("Сейчас пересменка");
    }
}
