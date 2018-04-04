package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 下午2:11
 */

public class FloatGenerator extends AbstractGenerator<Float> {
    public FloatGenerator(float lower, float upper) {
        super(lower, upper);
    }

    @Override
    public Float generate() {
        float value = getUpperBound() - getLowerBound();

        Random random = new Random();
        float result = random.nextFloat() % value;

        if (result < 0) {
            result += value;
        }

        return result;
    }
}