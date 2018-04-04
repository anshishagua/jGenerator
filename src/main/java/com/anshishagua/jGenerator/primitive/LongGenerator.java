package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:04
 */

public class LongGenerator extends AbstractGenerator<Long> {
    public static final long MIN = Long.MIN_VALUE;
    public static final long MAX = Long.MAX_VALUE;

    public LongGenerator() {
        super(MIN, MAX);
    }

    public LongGenerator(long min, long max) {
        super(min, max);
    }

    @Override
    public Long generate() {
        long diff = getUpperBound() - getLowerBound();

        Random random = new Random();

        long result = random.nextLong() % diff;

        if (result < 0) {
            result += diff;
        }

        return result;
    }
}
