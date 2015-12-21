package com.fewlaps.quitnowsleepingtime;

import java.util.Locale;

public class SleepingZone {
    Locale locale;

    public SleepingZone(Locale locale) {
        this.locale = locale;
    }

    public HourMinute getBedtime() {
        if (locale.getCountry().equalsIgnoreCase("es")) {
            return new HourMinute(0, 32);
        }
        return new HourMinute(23, 54);
    }

    public HourMinute getWakeUp() {
        if (locale.getCountry().equalsIgnoreCase("es")) {
            return new HourMinute(8, 5);
        }
        return new HourMinute(7, 20);
    }
}
