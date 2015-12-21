package com.fewlaps.quitnowsleepingtime;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SleepingZone {
    Locale locale;

    private static final Map<String, SleepTimes> times = new HashMap<String, SleepTimes>();

    public static final String DEFAULT_COUNTRY_CODE = "us";

    static {
        times.put(DEFAULT_COUNTRY_CODE, new SleepTimes(new HourMinute(23, 54), new HourMinute(7, 20)));
        times.put("es", new SleepTimes(new HourMinute(0, 32), new HourMinute(8, 5)));
        times.put("fr", new SleepTimes(new HourMinute(0, 19), new HourMinute(7, 51)));
    }

    public SleepingZone(Locale locale) {
        this.locale = locale;
    }

    public HourMinute getBedtime() {
        SleepTimes st = times.get(locale.getCountry().toLowerCase());
        if (st != null) {
            return st.bedTime;
        }
        return times.get(DEFAULT_COUNTRY_CODE).bedTime;
    }

    public HourMinute getWakeUp() {
        SleepTimes st = times.get(locale.getCountry().toLowerCase());
        if (st != null) {
            return st.wakeUpTime;
        }
        return times.get(DEFAULT_COUNTRY_CODE).wakeUpTime;
    }

    static class SleepTimes {
        public HourMinute bedTime;
        public HourMinute wakeUpTime;

        public SleepTimes(HourMinute bedTime, HourMinute wakeUpTime) {
            this.bedTime = bedTime;
            this.wakeUpTime = wakeUpTime;
        }
    }
}
