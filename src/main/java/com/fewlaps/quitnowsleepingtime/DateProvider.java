package com.fewlaps.quitnowsleepingtime;

interface DateProvider {

    long now();

    DateProvider SYSTEM = new DateProvider() {
        @Override
        public long now() {
            return System.currentTimeMillis();
        }
    };
}