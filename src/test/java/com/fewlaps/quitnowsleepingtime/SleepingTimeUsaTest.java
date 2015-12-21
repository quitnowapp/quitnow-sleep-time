package com.fewlaps.quitnowsleepingtime;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SleepingTimeUsaTest {

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    MockDateProvider mockDateProvider;
    SleepingTime st;

    @Before
    public void init() {
        mockDateProvider = new MockDateProvider();

        st = new SleepingTime(new Locale("en", "US"));
        st.setDateProvider(mockDateProvider);
    }

    @Test
    public void shouldSayUsaPeopleGoesToSleepAt_23_54() {
        assertEquals(23, st.getBedtime().getHour());
        assertEquals(54, st.getBedtime().getMinute());
    }

    @Test
    public void shouldSayUsaPeopleWakesUpAt_07_20() {
        assertEquals(7, st.getWakeUp().getHour());
        assertEquals(20, st.getWakeUp().getMinute());
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
    public void shouldSayFalseAt_23_53() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("23:53").getTime());

        assertFalse(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_23_54() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("23:54").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_23_55() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("23:55").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_07_19() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:19").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_07_20() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:20").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayFalseAt_07_21() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:21").getTime());

        assertFalse(st.isSleepingTime());
    }
}
