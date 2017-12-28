package com.fewlaps.quitnowsleepingtime;

import org.junit.Test;

import java.util.Locale;

import static com.fewlaps.quitnowsleepingtime.SleepingZone.DEFAULT_COUNTRY_CODE;
import static org.junit.Assert.assertEquals;

public class DefaultValuesTest {

    @Test
    public void shouldUseLocalLocaleByDefault() {
        SleepingTime defaultLocaleST = new SleepingTime();
        SleepingTime localLocaleST = new SleepingTime(Locale.getDefault().getCountry());

        assertEquals(localLocaleST.getBedtime(), defaultLocaleST.getBedtime());
        assertEquals(localLocaleST.getWakeUp(), defaultLocaleST.getWakeUp());
    }

    @Test
    public void shouldUseDefaultCountryCodeIfNotExistingLocale() {
        SleepingTime defaultCountryCodeSleepingTime = new SleepingTime(DEFAULT_COUNTRY_CODE);
        SleepingTime wrongLocaleSleepingTime = new SleepingTime("XX");

        assertEquals(wrongLocaleSleepingTime.getBedtime(), defaultCountryCodeSleepingTime.getBedtime());
        assertEquals(wrongLocaleSleepingTime.getWakeUp(), defaultCountryCodeSleepingTime.getWakeUp());
    }
}
