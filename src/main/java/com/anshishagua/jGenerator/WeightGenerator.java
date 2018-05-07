package com.anshishagua.jGenerator;

import com.anshishagua.jGenerator.primitive.IntGenerator;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午3:42
 */

public class WeightGenerator extends IntGenerator {
    public static final int MIN_WEIGHT_IN_KILOGRAM = 1;
    public static final int MAX_WEIGHT_IN_KILOGRAM = 250;

    public WeightGenerator(int minWeight, int maxWeight) {
        super(minWeight, maxWeight);
    }

    public WeightGenerator() {
        super(MIN_WEIGHT_IN_KILOGRAM, MAX_WEIGHT_IN_KILOGRAM);
    }

    @Override
    public Integer generate() {
        return super.generate();
    }
}