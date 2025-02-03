package com.group.libraryapp.dto.cacluator.response;

import java.time.DayOfWeek;

public class CalculatorDayOfWeek {
    private DayOfWeek dayOfTheWeek;

    public CalculatorDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfTheWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
