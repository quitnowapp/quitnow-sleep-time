package com.fewlaps.quitnowsleepingtime;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static junit.framework.Assert.assertEquals;

public class SleepingTimeTest {

    Locale spanishLocale = new Locale("es", "ES");
    MockDateProvider mockDateProvider;

    SleepingTime st;

    @Before
    public void init() {
        st = new SleepingTime(spanishLocale);
        st.setDateProvider(mockDateProvider);
    }

    @Test
    public void shouldSaySpanishPeopleGoesToSleepAt_00_32() {
        assertEquals(0, st.getBedtime().getHour());
        assertEquals(32, st.getBedtime().getMinute());
    }

    @Test
    public void shouldSaySpanishPeopleWakesUpAt_08_05() {
        assertEquals(8, st.getWakeUp().getHour());
        assertEquals(5, st.getWakeUp().getMinute());
    }
//
//    @Test
//    public void shouldSayFalseAt_00_00() {
//        mockDateProvider.setFixed();
//
//        assertEquals(8, st.getWakeUp().getHour());
//        assertEquals(5, st.getWakeUp().getMinute());
//    }
}
