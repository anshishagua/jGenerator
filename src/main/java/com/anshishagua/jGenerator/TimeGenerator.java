package com.anshishagua.jGenerator;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/29
 * Time: 上午9:27
 */

public class TimeGenerator implements Generator<LocalTime> {
    private LocalTime min;
    private LocalTime max;

    public TimeGenerator(LocalTime min, LocalTime max) {
        Objects.requireNonNull(min);
        Objects.requireNonNull(max);

        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Min could not greater than max");
        }

        this.min = min;
        this.max = max;
    }

    @Override
    public LocalTime generate() {
        long secondsBetween = Math.abs(ChronoUnit.SECONDS.between(max, min)) + 1;

        Random random = new Random();

        long secondsToAdd = random.nextLong() % secondsBetween;

        if (secondsToAdd < 0) {
            secondsToAdd += secondsBetween;
        }

        return min.plusSeconds(secondsToAdd);
    }
}
