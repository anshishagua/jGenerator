package com.anshishagua.jGenerator;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:41
 */

public class StringGenerator implements Generator<String> {
    private final int minLength;
    private final int maxLength;

    public StringGenerator() {
        minLength = 1;
        maxLength = Integer.MAX_VALUE;
    }

    public StringGenerator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public String generate() {
        return null;
    }
}
