package ProjectOOP;

import java.util.Objects;

public class Event {

    private int hour;
    private int minute;
    private int day;

    public Event(int hour, int minute, int day) {
        this.hour = hour;
        this.minute = minute;
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "day=" + day + ", time=" + hour + ":" + minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return hour == event.hour && minute == event.minute && day == event.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, day);
    }
}
