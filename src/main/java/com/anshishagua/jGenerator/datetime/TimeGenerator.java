package com.anshishagua.jGenerator.datetime;

import com.anshishagua.jGenerator.AbstractGenerator;
import com.anshishagua.jGenerator.Generator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/29
 * Time: 上午9:27
 */

public class TimeGenerator extends AbstractGenerator<LocalTime> {
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public TimeGenerator(String minString, String maxString) {
        super(LocalTime.parse(minString, TIME_FORMATTER), LocalTime.parse(maxString, TIME_FORMATTER));
    }

    public TimeGenerator(LocalTime min, LocalTime max) {
        super(min, max);
    }

    @Override
    public LocalTime generate() {
        long secondsBetween = Math.abs(ChronoUnit.SECONDS.between(getUpperBound(), getLowerBound())) + 1;

        Random random = new Random();

        long secondsToAdd = random.nextLong() % secondsBetween;

        if (secondsToAdd < 0) {
            secondsToAdd += secondsBetween;
        }

        return getLowerBound().plusSeconds(secondsToAdd);
    }
}