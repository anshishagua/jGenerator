package com.anshishagua.jGenerator;

import java.util.Objects;

/**
 * User: lixiao
 * Date: 2018/3/29
 * Time: 上午10:02
 */

public abstract class AbstractGenerator<T extends Comparable<T>> implements Generator<T> {
    private final T lowerBound;
    private final T upperBound;

    public AbstractGenerator(T lowerBound, T upperBound) {
        Objects.requireNonNull(lowerBound);
        Objects.requireNonNull(upperBound);

        if (lowerBound.compareTo(upperBound) > 0) {
            throw new IllegalArgumentException("Lower bound greater than upper bound");
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public T getLowerBound() {
        return lowerBound;
    }

    public T getUpperBound() {
        return upperBound;
    }
}