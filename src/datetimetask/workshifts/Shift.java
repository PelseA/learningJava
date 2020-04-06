package datetimetask.workshifts;

import java.time.LocalTime;

public enum Shift {
    MORNING(LocalTime.of(7, 0), LocalTime.of(15, 0)),
    EVENING(LocalTime.of(15, 0), LocalTime.of(23, 0)),
    NIGHT(LocalTime.of(23, 0), LocalTime.of(7, 0));

    private LocalTime start;
    private LocalTime finish;

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    Shift(LocalTime start, LocalTime finish) {
        this.start = start;
        this.finish = finish;
    }
}
