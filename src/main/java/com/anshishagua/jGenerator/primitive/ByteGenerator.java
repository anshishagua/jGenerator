package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 下午2:08
 */

public class ByteGenerator extends AbstractGenerator<Byte> {
    public ByteGenerator(byte min, byte max) {
        super(min, max);
    }

    public ByteGenerator() {
        super(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    @Override
    public Byte generate() {
        Random random = new Random();
        int size = getUpperBound() - getLowerBound() + 1;

        return (byte) (new Random().nextInt(size) + getLowerBound());
    }
}