package com.anshishagua.jGenerator.distribution;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/5/7
 * Time: 上午10:40
 */

public class GaussianDistribution {
    private double average;
    private double standardDeviation;
    private ThreadLocal<Random> threadLocal;

    public GaussianDistribution(double average, double standardDeviation) {
        this.average = average;
        this.standardDeviation = standardDeviation;
        this.threadLocal = new ThreadLocal<Random>() {
            public Random initialValue() {
                return new Random();
            }
        };
    }

    public double getAverage() {
        return average;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double next() {
        Random random = threadLocal.get();

        // if x ~ N[a, b * b]
        // (x - a) / b ~ N[0, 1]

        return random.nextGaussian() * standardDeviation + average;
    }
}