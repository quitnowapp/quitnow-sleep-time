package com.fewlaps.quitnowsleepingtime;

import java.util.Locale;

public class SleepingTime {

    private DateProvider dateProvider = DateProvider.SYSTEM;

    HourMinute bedTime;
    HourMinute wakeUpTime;

    public SleepingTime(Locale locale) {
        SleepingZone sz = new SleepingZone(locale);

        bedTime = sz.getBedtime();
        wakeUpTime = sz.getWakeUp();
    }

    public SleepingTime() {
        SleepingZone sz = new SleepingZone(Locale.getDefault());

        bedTime = sz.getBedtime();
        wakeUpTime = sz.getWakeUp();
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

    public boolean isSleepingTime() {
        HourMinute now = new HourMinute(dateProvider.now());

        if (getBedtime().isBeforeMidnight()) {
            int minutesUntilMidnight = getBedtime().getMinutesUntilMidnight();

            HourMinute bedTimeWithOffset = getBedtime().addMinutes(minutesUntilMidnight);
            HourMinute wakeUpTimeWithOffset = getWakeUp().addMinutes(minutesUntilMidnight);
            HourMinute nowWithOffset = now.addMinutes(minutesUntilMidnight);

            return nowWithOffset.isAfter(bedTimeWithOffset) && (nowWithOffset.isBefore(wakeUpTimeWithOffset) || nowWithOffset.equals(wakeUpTimeWithOffset));
        } else {
            return now.isAfter(getBedtime()) && (now.isBefore(getWakeUp()) || now.equals(getWakeUp()));
        }
    }
}
