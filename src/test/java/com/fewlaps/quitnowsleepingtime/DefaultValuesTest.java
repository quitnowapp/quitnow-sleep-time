package com.fewlaps.quitnowsleepingtime;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class DefaultValuesTest {

    @Test
    public void shouldUseLocalLocaleByDefault() {
        SleepingTime defaultLocaleST = new SleepingTime();
        SleepingTime localLocaleST = new SleepingTime(Locale.getDefault());

        assertEquals(localLocaleST.getBedtime(), defaultLocaleST.getBedtime());
        assertEquals(localLocaleST.getWakeUp(), defaultLocaleST.getWakeUp());
    }
}
