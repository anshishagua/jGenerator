package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 下午2:02
 */

public class ShortGenerator extends AbstractGenerator<Short> {
    public ShortGenerator() {
        super(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    public ShortGenerator(short min, short max) {
        super(min, max);
    }

    @Override
    public Short generate() {
        Random random = new Random();
        int size = getUpperBound() - getLowerBound() + 1;

        //[min, max] = [min, max + 1)
        //[0, max - min] = [0, max - min + 1)
        //bound = max - min + 1
        return (short) (new Random().nextInt(size) + getLowerBound());
    }
}