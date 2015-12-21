package com.fewlaps.quitnowsleepingtime;

import org.junit.Test;

import java.util.Locale;

public class IntroducingQNSleepingTimeTest {

    @Test
    public void theCodeOfTheReadmeWorks() {
        SleepingTime st = new SleepingTime();
        st.isSleepingTime();
        st.getBedtime();
        st.getWakeUp();

        new SleepingTime(new Locale("es", "ES")).isSleepingTime();
    }
}
