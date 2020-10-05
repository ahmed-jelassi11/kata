package com.bank.kata.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {

    @Test
    public void test_return_instant_date() {
        Clock clock = new TestableClock();
        String date = clock.now();
        assertEquals("05/10/2020", date);
    }


    private class TestableClock extends Clock {
        @Override
        protected LocalDate getDate() {
            return LocalDate.of(2020, 10, 5);
        }
    }

}
