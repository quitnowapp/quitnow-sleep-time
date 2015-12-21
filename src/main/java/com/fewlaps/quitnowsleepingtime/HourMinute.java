package com.fewlaps.quitnowsleepingtime;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HourMinute {
    int time; //minutes since 00:00

    public HourMinute() {
        GregorianCalendar gc = new GregorianCalendar();
        time = gc.get(Calendar.HOUR) * 60 + gc.get(Calendar.MINUTE);
    }

    public HourMinute(int hour, int minute) {
        time = hour * 60 + minute;
    }

    public int getHour() {
        return time / 60;
    }

    public int getMinute() {
        return time % 60;
    }
}
