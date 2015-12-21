package com.fewlaps.quitnowsleepingtime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HourMinute {
    public static final int MID_DAY_HOUR = 12;
    public static final int MINUTES_IN_A_DAY = 1440;
    int time; //minutes since 00:00

    public HourMinute() {
        GregorianCalendar gc = new GregorianCalendar();
        time = gc.get(Calendar.HOUR_OF_DAY) * 60 + gc.get(Calendar.MINUTE);
    }

    public HourMinute(int minutes) {
        time = minutes % MINUTES_IN_A_DAY;
    }

    public HourMinute(long millis) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date(millis));
        time = gc.get(Calendar.HOUR_OF_DAY) * 60 + gc.get(Calendar.MINUTE);
    }

    public HourMinute(int hour, int minute) {
        time = hour * 60 + minute;
    }

    private int getTime() {
        return time;
    }

    public int getHour() {
        return time / 60;
    }

    public int getMinute() {
        return time % 60;
    }

    public boolean isBefore(HourMinute hm) {
        return time < hm.getTime();
    }

    public boolean isAfter(HourMinute hm) {
        return !isBefore(hm);
    }

    @Override
    public String toString() {
        return getHour() + ":" + getMinute();
    }

    public int getMinutesUntil(HourMinute hm) {
        int result = hm.getTime() - time;
        if (result < 0) {
            result = hm.getTime() - time + 24 * 60;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HourMinute that = (HourMinute) o;

        return time == that.time;

    }

    @Override
    public int hashCode() {
        return time;
    }

    public boolean isBeforeMidnight() {
        return getHour() > MID_DAY_HOUR;
    }

    public int getMinutesUntilMidnight() {
        return (new HourMinute(24, 00).getTime() - time) % MINUTES_IN_A_DAY;
    }

    public HourMinute addMinutes(int minutes) {
        return new HourMinute(time + minutes);
    }
}
