package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/29
 * Time: 上午10:27
 */

public class DoubleGenerator extends AbstractGenerator<Double> {
    public DoubleGenerator() {
        super(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public DoubleGenerator(double lower, double upper) {
        super(lower, upper);
    }

    @Override
    public Double generate() {
        double value = getUpperBound() - getLowerBound();

        Random random = new Random();
        double result = random.nextDouble() % value;

        if (result < 0) {
            result += value;
        }

        return result;
    }
}
