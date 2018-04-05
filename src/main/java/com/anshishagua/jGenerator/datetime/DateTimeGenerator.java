package com.anshishagua.jGenerator.datetime;

import com.anshishagua.jGenerator.AbstractGenerator;
import com.anshishagua.jGenerator.Generator;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
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

public class DateTimeGenerator extends AbstractGenerator<ChronoLocalDateTime<?>> {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DateTimeGenerator() {
        super(LocalDateTime.MIN, LocalDateTime.MAX);
    }

    public DateTimeGenerator(String minString, String maxString) {
        super(LocalDateTime.parse(minString, DATE_TIME_FORMATTER), LocalDateTime.parse(maxString, DATE_TIME_FORMATTER));
    }

    public DateTimeGenerator(LocalDateTime min, LocalDateTime max) {
        super(min, max);
    }

    @Override
    public LocalDateTime generate() {
        long secondsBetween = Math.abs(ChronoUnit.SECONDS.between(getUpperBound(), getLowerBound())) + 1;

        Random random = new Random();

        long secondsToAdd = random.nextLong() % secondsBetween;

        if (secondsToAdd < 0) {
            secondsToAdd += secondsBetween;
        }

        return ((LocalDateTime) getLowerBound()).plusSeconds(secondsToAdd);
    }
}
