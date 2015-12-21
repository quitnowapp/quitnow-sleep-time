package com.fewlaps.quitnowsleepingtime;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SleepingTimeFranceTest {

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    MockDateProvider mockDateProvider;
    SleepingTime st;

    @Before
    public void init() {
        mockDateProvider = new MockDateProvider();

        st = new SleepingTime("FR");
        st.setDateProvider(mockDateProvider);
    }

    @Test
    public void shouldSayFrenchPeopleGoesToSleepAt_00_19() {
        assertEquals(00, st.getBedtime().getHour());
        assertEquals(19, st.getBedtime().getMinute());
    }

    @Test
    public void shouldSayFrenchPeopleWakesUpAt_07_51() {
        assertEquals(7, st.getWakeUp().getHour());
        assertEquals(51, st.getWakeUp().getMinute());
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
    public void shouldSayFalseAt_00_18() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:18").getTime());

        assertFalse(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_00_19() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:19").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_00_20() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("00:20").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_7_50() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:50").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayTrueAt_07_51() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:51").getTime());

        assertTrue(st.isSleepingTime());
    }

    @Test
    public void shouldSayFalseAt_07_52() throws ParseException {
        mockDateProvider.setFixed(sdf.parse("07:52").getTime());

        assertFalse(st.isSleepingTime());
    }
}
