package com.anshishagua.jGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:04
 */

public class IDGenerator implements Generator<Long> {
    private AtomicLong atomicLong;

    public IDGenerator() {
        atomicLong = new AtomicLong(0);
    }

    public IDGenerator(long start) {
        atomicLong = new AtomicLong(start);
    }

    @Override
    public Long generate() {
        return atomicLong.getAndIncrement();
    }
}