package com.fewlaps.quitnowsleepingtime;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class HourMinuteTest {

    @Test
     public void shouldUseActualHourMinutesByDefault() {
        HourMinute hm = new HourMinute();
        GregorianCalendar gc = new GregorianCalendar();
        int hour = gc.get(Calendar.HOUR);
        int minute = gc.get(Calendar.MINUTE);

        assertEquals(hour, hm.getHour());
        assertEquals(minute, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_00_00() {
        HourMinute hm = new HourMinute(0,0);

        assertEquals(0, hm.getHour());
        assertEquals(0, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_23_59() {
        HourMinute hm = new HourMinute(23,59);

        assertEquals(23, hm.getHour());
        assertEquals(59, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_19_24() {
        HourMinute hm = new HourMinute(19,24);

        assertEquals(19, hm.getHour());
        assertEquals(24, hm.getMinute());
    }
}
