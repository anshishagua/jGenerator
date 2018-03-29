package com.anshishagua.jGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午11:26
 */

public class DateTimeGenerator implements Generator<LocalDateTime> {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTime min;
    private LocalDateTime max;

    public DateTimeGenerator(String minString, String maxString) {
        try {
            min = LocalDateTime.parse(minString, DATE_TIME_FORMATTER);
            max = LocalDateTime.parse(maxString, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public DateTimeGenerator(LocalDateTime min, LocalDateTime max) {
        Objects.requireNonNull(min, "min could not be null");
        Objects.requireNonNull(max, "max could not be null");

        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Min could not be greater than max");
        }

        this.min = min;
        this.max = max;
    }

    @Override
    public LocalDateTime generate() {
        long secondsBetween = Math.abs(ChronoUnit.SECONDS.between(max, min)) + 1;

        Random random = new Random();

        long secondsToAdd = random.nextLong() % secondsBetween;

        if (secondsToAdd < 0) {
            secondsToAdd += secondsBetween;
        }

        return min.plusSeconds(secondsToAdd);
    }
}
