package com.anshishagua.jGenerator.distribution;

import com.anshishagua.jGenerator.utils.AssertUtils;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/5/7
 * Time: 上午10:40
 */

public class UniformDistribution {
    private double lower;
    private double upper;
    private double difference;
    private ThreadLocal<Random> threadLocal;

    public UniformDistribution(double lower, double upper) {
        AssertUtils.assertTrue(lower <= upper, String.format("Lower:%s should not >= Upper:%s", lower, upper));

        this.lower = lower;
        this.upper = upper;
        this.difference = upper - lower;

        this.threadLocal = new ThreadLocal<Random>() {
            public Random initialValue() {
                return new Random();
            }
        };
    }

    public double next() {
        Random random = threadLocal.get();

        double result = random.nextDouble() % difference;

        if (result < 0) {
            result += difference;
        }

        return result;
    }

    public static void main(String [] args) {
        UniformDistribution distribution = new UniformDistribution(0, 1);

        for (int i = 0; i < 10; ++i) {
            System.out.println(distribution.next());
        }
    }
}