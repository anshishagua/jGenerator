package com.anshishagua.jGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:54
 */

public class DateGenerator implements Generator<LocalDate> {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate min;
    private LocalDate max;

    public DateGenerator(LocalDate min, LocalDate max) {
        Objects.requireNonNull(min);
        Objects.requireNonNull(max);

        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Parameter min:" + min + " should not greater than max:" + max);
        }

        this.min = min;
        this.max = max;
    }

    public LocalDate getMin() {
        return min;
    }

    public LocalDate getMax() {
        return max;
    }

    public DateGenerator(String minString, String maxString) {
        try {
            min = LocalDate.parse(minString, DATE_FORMATTER);
            max = LocalDate.parse(maxString, DATE_FORMATTER);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public LocalDate generate() {
        long daysBetween = Math.abs(ChronoUnit.DAYS.between(max, min));

        Random random = new Random();

        ++daysBetween;

        long daysToAdd = random.nextLong() % daysBetween;

        if (daysToAdd < 0) {
            daysToAdd += daysBetween;
        }

        return min.plusDays(daysToAdd);
    }
}
