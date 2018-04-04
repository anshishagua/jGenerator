package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.Generator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:40
 */

public class IntGenerator implements Generator<Integer> {
    private final int min;
    private final int max;

    public IntGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Integer generate() {
        int size = max - min + 1;

        //[min, max] = [min, max + 1)
        //[0, max - min] = [0, max - min + 1)
        //bound = max - min + 1
        return new Random().nextInt(size) + min;
    }
}