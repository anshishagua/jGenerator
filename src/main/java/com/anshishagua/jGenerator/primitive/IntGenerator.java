package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;
import com.anshishagua.jGenerator.Generator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:40
 */

public class IntGenerator extends AbstractGenerator<Integer> {
    public IntGenerator() {
        super(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public IntGenerator(int min, int max) {
        super(min, max);
    }

    public Integer generate() {
        int size = getUpperBound() - getLowerBound() + 1;

        //[min, max] = [min, max + 1)
        //[0, max - min] = [0, max - min + 1)
        //bound = max - min + 1
        return new Random().nextInt(size) + getLowerBound();
    }
}