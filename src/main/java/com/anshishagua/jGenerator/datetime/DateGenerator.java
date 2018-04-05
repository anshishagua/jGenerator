package com.anshishagua.jGenerator.datetime;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:54
 */

public class DateGenerator extends AbstractGenerator<ChronoLocalDate> {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DateGenerator() {
        super(LocalDate.MIN, LocalDate.MAX);
    }

    public DateGenerator(LocalDate min, LocalDate max) {
        super(min, max);
    }

    public DateGenerator(String minString, String maxString) {
        super(LocalDate.parse(minString, DATE_FORMATTER), LocalDate.parse(maxString, DATE_FORMATTER));
    }

    @Override
    public LocalDate generate() {
        long daysBetween = Math.abs(ChronoUnit.DAYS.between(getUpperBound(), getLowerBound()));

        Random random = new Random();

        ++daysBetween;

        long daysToAdd = random.nextLong() % daysBetween;

        if (daysToAdd < 0) {
            daysToAdd += daysBetween;
        }

        return ((LocalDate) getLowerBound()).plusDays(daysToAdd);
    }
}