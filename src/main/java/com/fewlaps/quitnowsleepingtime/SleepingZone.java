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
        times.put("de", new SleepTimes(new HourMinute(23, 59), new HourMinute(7, 25)));
        times.put("it", new SleepTimes(new HourMinute(00, 35), new HourMinute(7, 52)));
        times.put("gr", new SleepTimes(new HourMinute(01, 05), new HourMinute(8, 25)));
        times.put("gb", new SleepTimes(new HourMinute(00, 28), new HourMinute(7, 33)));
        times.put("nl", new SleepTimes(new HourMinute(00, 17), new HourMinute(7, 47)));
        times.put("ru", new SleepTimes(new HourMinute(01, 05), new HourMinute(8, 06)));
        times.put("pl", new SleepTimes(new HourMinute(00, 55), new HourMinute(7, 25)));
        times.put("cn", new SleepTimes(new HourMinute(00, 32), new HourMinute(8, 06)));
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
