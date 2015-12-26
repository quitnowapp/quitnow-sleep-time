package com.fewlaps.quitnowsleepingtime;

import java.util.HashMap;
import java.util.Map;

public class SleepingZone {

    public static final String DEFAULT_COUNTRY_CODE = "us";

    private static final Map<String, SleepTimes> times = new HashMap<String, SleepTimes>();

    static {
        times.put(DEFAULT_COUNTRY_CODE, new SleepTimes(new HourMinute(23, 54), new HourMinute(7, 20)));
        times.put("es", new SleepTimes(new HourMinute(0, 32), new HourMinute(8, 5))); //SPAIN
        times.put("fr", new SleepTimes(new HourMinute(0, 19), new HourMinute(7, 51))); //FRANCE
        times.put("de", new SleepTimes(new HourMinute(23, 59), new HourMinute(7, 25))); //GERMANY
        times.put("it", new SleepTimes(new HourMinute(0, 35), new HourMinute(7, 52))); //ITALY
        times.put("gr", new SleepTimes(new HourMinute(1, 5), new HourMinute(8, 25))); //GREECE
        times.put("gb", new SleepTimes(new HourMinute(0, 28), new HourMinute(7, 33))); //UNITED KINGDOM
        times.put("nl", new SleepTimes(new HourMinute(0, 17), new HourMinute(7, 47))); //NETHERLANDS
        times.put("ru", new SleepTimes(new HourMinute(1, 5), new HourMinute(8, 6))); //RUSSIA
        times.put("pl", new SleepTimes(new HourMinute(0, 55), new HourMinute(7, 25))); //POLAND
        times.put("cn", new SleepTimes(new HourMinute(0, 32), new HourMinute(8, 6))); //CHINA
        times.put("sk", new SleepTimes(new HourMinute(1, 3), new HourMinute(7, 18))); //SLOVAKIA
        times.put("hu", new SleepTimes(new HourMinute(23, 59), new HourMinute(7, 22))); //HUNGARY
        times.put("cz", new SleepTimes(new HourMinute(23, 58), new HourMinute(7, 15))); //CZECH REPUBLIC
        times.put("ch", new SleepTimes(new HourMinute(0, 19), new HourMinute(7, 13))); //SWITZERLAND
        times.put("tw", new SleepTimes(new HourMinute(0, 37), new HourMinute(7, 56))); //TAIWAN
        times.put("at", new SleepTimes(new HourMinute(23, 55), new HourMinute(7, 20))); //AUSTRIA
        times.put("ua", new SleepTimes(new HourMinute(0, 3), new HourMinute(7, 51))); //UKRAINE
        times.put("pt", new SleepTimes(new HourMinute(0, 41), new HourMinute(8, 22))); //PORTUGAL
        times.put("ro", new SleepTimes(new HourMinute(23, 9), new HourMinute(8, 1))); //ROMANIA
        times.put("co", new SleepTimes(new HourMinute(23, 41), new HourMinute(6, 31))); //COLOMBIA
        times.put("hk", new SleepTimes(new HourMinute(0, 55), new HourMinute(7, 57))); //HONG KONG
        times.put("th", new SleepTimes(new HourMinute(0, 22), new HourMinute(7, 24))); //THAILAND
        times.put("be", new SleepTimes(new HourMinute(0, 6), new HourMinute(7, 40))); //BELGIUM
        times.put("kr", new SleepTimes(new HourMinute(0, 16), new HourMinute(7, 38))); //SOUTH KOREA
        times.put("dk", new SleepTimes(new HourMinute(23, 47), new HourMinute(7, 19))); //DENMARK
        times.put("in", new SleepTimes(new HourMinute(0, 26), new HourMinute(7, 36))); //INDIA
        times.put("fi", new SleepTimes(new HourMinute(0, 3), new HourMinute(7, 44))); //FINLAND
        times.put("il", new SleepTimes(new HourMinute(0, 44), new HourMinute(7, 54))); //ISRAEL
        times.put("tr", new SleepTimes(new HourMinute(0, 59), new HourMinute(8, 2))); //TURKEY
        times.put("br", new SleepTimes(new HourMinute(0, 32), new HourMinute(7, 31))); //BRAZIL
        times.put("sg", new SleepTimes(new HourMinute(23, 52), new HourMinute(7, 38))); //SINGAPORE
        times.put("cl", new SleepTimes(new HourMinute(0, 47), new HourMinute(7, 40))); //CHILE
        times.put("mx", new SleepTimes(new HourMinute(0, 20), new HourMinute(7, 9))); //MEXICO
        times.put("se", new SleepTimes(new HourMinute(23, 50), new HourMinute(7, 21))); //SWEDEN
        times.put("cr", new SleepTimes(new HourMinute(23, 43), new HourMinute(6, 38))); //COSTA RICA
        times.put("jp", new SleepTimes(new HourMinute(0, 49), new HourMinute(7, 9))); //JAPAN
        times.put("ae", new SleepTimes(new HourMinute(1, 5), new HourMinute(7, 43))); //UNITED ARAB EMIRATES
        times.put("id", new SleepTimes(new HourMinute(0, 10), new HourMinute(6, 55))); //INDONESIA
        times.put("za", new SleepTimes(new HourMinute(0, 20), new HourMinute(6, 24))); //SOUTH AFRICA
        times.put("qa", new SleepTimes(new HourMinute(0, 6), new HourMinute(7, 32))); //QATAR
        times.put("no", new SleepTimes(new HourMinute(0, 16), new HourMinute(7, 43))); //NORWAY
        times.put("ca", new SleepTimes(new HourMinute(23, 57), new HourMinute(7, 33))); //CANADA
        times.put("ph", new SleepTimes(new HourMinute(0, 39), new HourMinute(7, 28))); //PHILIPPINES
        times.put("kw", new SleepTimes(new HourMinute(0, 14), new HourMinute(8, 1))); //KUWAIT
        times.put("sa", new SleepTimes(new HourMinute(0, 39), new HourMinute(8, 27))); //SAUDI ARABIA
        times.put("au", new SleepTimes(new HourMinute(23, 33), new HourMinute(7, 13))); //AUSTRALIA
        times.put("nz", new SleepTimes(new HourMinute(23, 29), new HourMinute(7, 11))); //NEW ZEALAND
        times.put("ie", new SleepTimes(new HourMinute(0, 16), new HourMinute(7, 50))); //IRELAND
        times.put("my", new SleepTimes(new HourMinute(0, 35), new HourMinute(7, 41))); //MALAYSIA
    }

    private String countryCode;

    public SleepingZone(String countryCode) {
        this.countryCode = countryCode;
    }

    public HourMinute getBedtime() {
        SleepTimes st = times.get(countryCode.toLowerCase());
        if (st != null) {
            return st.bedTime;
        }
        return times.get(DEFAULT_COUNTRY_CODE).bedTime;
    }

    public HourMinute getWakeUp() {
        SleepTimes st = times.get(countryCode.toLowerCase());
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
