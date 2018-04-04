package com.anshishagua.jGenerator;

import com.anshishagua.jGenerator.primitive.IntGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:41
 */

public class StringGenerator implements Generator<String> {
    private final int minLength;
    private final int maxLength;
    private final boolean nullable;

    public StringGenerator() {
        this.minLength = 1;
        this.maxLength = Integer.MAX_VALUE;
        this.nullable = false;
    }

    public StringGenerator(int minLength, int maxLength, boolean nullable) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.nullable = nullable;
    }

    public StringGenerator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.nullable = false;
    }

    public String generate() {
        StringBuilder builder = new StringBuilder();

        IntGenerator intGenerator = new IntGenerator(minLength, maxLength);

        if (nullable && new Random().nextInt(1) == 0) {
            return null;
        }

        int len = intGenerator.generate();

        while (len-- > 0) {
            builder.append((char) (new Random().nextInt(26) + 'A'));
        }

        return builder.toString();
    }
}
