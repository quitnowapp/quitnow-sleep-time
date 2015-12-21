package com.fewlaps.quitnowsleepingtime;

import java.util.Locale;

public class SleepingTime {

    private DateProvider dateProvider = DateProvider.SYSTEM;

    HourMinute bedTime;
    HourMinute wakeUpTime;

    public SleepingTime(Locale locale) {
        bedTime = new HourMinute(0, 32);
        wakeUpTime = new HourMinute(8, 5);

    }

    public HourMinute getBedtime() {
        return bedTime;
    }

    public HourMinute getWakeUp() {
        return wakeUpTime;
    }

    protected void setDateProvider(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }
}
