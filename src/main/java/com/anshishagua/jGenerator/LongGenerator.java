package com.anshishagua.jGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:04
 */

public class LongGenerator implements Generator<Long> {
    public static final long MIN = Long.MIN_VALUE;
    public static final long MAX = Long.MAX_VALUE;

    private long min;
    private long max;

    public LongGenerator(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Long generate() {
        Random random = new Random();

        return random.nextLong();
    }
}
