package com.fewlaps.quitnowsleepingtime;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HourMinuteTest {

    @Test
    public void shouldUseActualHourMinutesByDefault() {
        HourMinute hm = new HourMinute();
        GregorianCalendar gc = new GregorianCalendar();
        int hour = gc.get(Calendar.HOUR_OF_DAY);
        int minute = gc.get(Calendar.MINUTE);

        assertEquals(hour, hm.getHour());
        assertEquals(minute, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_00_00() {
        HourMinute hm = new HourMinute(0, 0);

        assertEquals(0, hm.getHour());
        assertEquals(0, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_23_59() {
        HourMinute hm = new HourMinute(23, 59);

        assertEquals(23, hm.getHour());
        assertEquals(59, hm.getMinute());
    }

    @Test
    public void shouldUseHardcodedValuesIfUsedThemAtCreationTime_19_24() {
        HourMinute hm = new HourMinute(19, 24);

        assertEquals(19, hm.getHour());
        assertEquals(24, hm.getMinute());
    }

    @Test
    public void shouldWorkWhenCreatedWithMillis() {
        GregorianCalendar gc = new GregorianCalendar();
        int hour = gc.get(Calendar.HOUR_OF_DAY);
        int minute = gc.get(Calendar.MINUTE);

        HourMinute hm = new HourMinute(gc.getTimeInMillis());

        assertEquals(hour, hm.getHour());
        assertEquals(minute, hm.getMinute());
    }

    @Test
     public void shouldWorkWhenCreatedWithMinutes() {
        HourMinute hm = new HourMinute(5);

        assertEquals(0, hm.getHour());
        assertEquals(5, hm.getMinute());
    }

    @Test
    public void shouldWorkWhenCreatedWithMinutesAtMidNight() {
        HourMinute hm = new HourMinute(1440);

        assertEquals(0, hm.getHour());
        assertEquals(0, hm.getMinute());
    }

    @Test
    public void shouldWorkWhenCreatedWithMinutesAtMidNightPlus42() {
        HourMinute hm = new HourMinute(1482);

        assertEquals(0, hm.getHour());
        assertEquals(42, hm.getMinute());
    }

    @Test
    public void testHourMinuteBeforeWithMinutes() {
        HourMinute hm1 = new HourMinute(19, 24);
        HourMinute hm2 = new HourMinute(19, 25);

        assertTrue(hm1.isBefore(hm2));
    }

    @Test
    public void testHourMinuteBeforeWithHours() {
        HourMinute hm1 = new HourMinute(19, 00);
        HourMinute hm2 = new HourMinute(20, 00);

        assertTrue(hm1.isBefore(hm2));
    }

    @Test
    public void testHourMinuteAfterWithMinutes() {
        HourMinute hm1 = new HourMinute(19, 24);
        HourMinute hm2 = new HourMinute(19, 25);

        assertTrue(hm2.isAfter(hm1));
    }

    @Test
    public void testHourMinuteAfterWithHours() {
        HourMinute hm1 = new HourMinute(19, 00);
        HourMinute hm2 = new HourMinute(20, 00);

        assertTrue(hm2.isAfter(hm1));
    }

    @Test
    public void testHourMinuteEquals1() {
        HourMinute hm1 = new HourMinute(12, 42);
        HourMinute hm2 = new HourMinute(12, 42);

        assertTrue(hm2.equals(hm1));
    }

    @Test
    public void testHourMinuteEquals2() {
        HourMinute hm1 = new HourMinute(12, 42);
        HourMinute hm2 = new HourMinute(12, 43);

        assertFalse(hm2.equals(hm1));
    }

    @Test
    public void testMinutesUntil1() {
        HourMinute hm1 = new HourMinute(19, 00);
        HourMinute hm2 = new HourMinute(20, 00);

        assertEquals(60, hm1.getMinutesUntil(hm2));
    }

    @Test
    public void testMinutesUntil2() {
        HourMinute hm1 = new HourMinute(00, 00);
        HourMinute hm2 = new HourMinute(00, 42);

        assertEquals(42, hm1.getMinutesUntil(hm2));
    }

    @Test
    public void testMinutesUntil3() {
        HourMinute hm1 = new HourMinute(23, 00);
        HourMinute hm2 = new HourMinute(01, 00);

        assertEquals(120, hm1.getMinutesUntil(hm2));
    }

    @Test
    public void testIsBeforeMidnight1(){
        assertTrue(new HourMinute(23, 59).isBeforeMidnight());
    }

    @Test
    public void testIsBeforeMidnight2(){
        assertFalse(new HourMinute(00, 00).isBeforeMidnight());
    }

    @Test
    public void testIsBeforeMidnight3(){
        assertFalse(new HourMinute(00, 01).isBeforeMidnight());
    }

    @Test
    public void testMinutesUntilMidnight1(){
        assertEquals(1, new HourMinute(23, 59).getMinutesUntilMidnight());
    }

    @Test
    public void testMinutesUntilMidnight2(){
        assertEquals(0, new HourMinute(00, 00).getMinutesUntilMidnight());
    }

    @Test
    public void testMinutesUntilMidnight3(){
        assertEquals(1439, new HourMinute(00, 01).getMinutesUntilMidnight());
    }

    @Test
    public void testAddMinutes1(){
        HourMinute hm = new HourMinute(13, 50).addMinutes(1);
        assertEquals(13, hm.getHour());
        assertEquals(51, hm.getMinute());
    }

    @Test
    public void testAddMinutes2(){
        HourMinute hm = new HourMinute(13, 50).addMinutes(10);
        assertEquals(14, hm.getHour());
        assertEquals(00, hm.getMinute());
    }

    @Test
    public void testAddMinutes3(){
        HourMinute hm = new HourMinute(13, 50).addMinutes(20);
        assertEquals(14, hm.getHour());
        assertEquals(10, hm.getMinute());
    }

    @Test
    public void testAddMinutes4(){
        HourMinute hm = new HourMinute(23, 50).addMinutes(5);
        assertEquals(23, hm.getHour());
        assertEquals(55, hm.getMinute());
    }

    @Test
    public void testAddMinutes5(){
        HourMinute hm = new HourMinute(23, 50).addMinutes(10);
        assertEquals(00, hm.getHour());
        assertEquals(00, hm.getMinute());
    }

    @Test
    public void testAddMinutes6(){
        HourMinute hm = new HourMinute(23, 50).addMinutes(20);
        assertEquals(00, hm.getHour());
        assertEquals(10, hm.getMinute());
    }
    @Test
    public void testToString(){
        HourMinute hm = new HourMinute(23, 5);
        assertEquals(hm.toString(), "23:05");
    }

    @Test
    public void testToString2(){
        HourMinute hm = new HourMinute(23, 10);
        assertEquals(hm.toString(), "23:10");
    }

}
