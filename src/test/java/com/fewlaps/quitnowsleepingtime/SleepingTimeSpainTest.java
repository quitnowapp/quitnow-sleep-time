package com.fewlaps.quitnowsleepingtime;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SleepingTimeSpainTest {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    Locale spanishLocale = new Locale("es", "ES");
    MockDateProvider mockDateProvider = new MockDateProvider();

    SleepingTime st;

    @Before
    public void init() {
        mockDateProvider = new MockDateProvider();

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

    @Test
    public void shouldSayFalseAt_18_42() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("18:42").getTime());

        assertFalse(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_04_12() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("04:12").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayFalseAt_00_31() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:31").getTime());

        assertFalse(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_00_32() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:32").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_00_33() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:33").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_08_04() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("08:04").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_08_05() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("08:05").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayFalseAt_08_06() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("08:06").getTime());

        assertFalse(st.isSleepingTime());
    }
}
