package com.anshishagua.jGenerator;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午3:42
 */

public class HeightGenerator extends IntGenerator {
    public static final int MIN_HEIGHT_IN_CENTIMETER = 30;
    public static final int MAX_HEIGHT_IN_CENTIMETER = 250;

    public HeightGenerator(int minHeight, int maxHeight) {
        super(minHeight, maxHeight);
    }

    public HeightGenerator() {
        super(MIN_HEIGHT_IN_CENTIMETER, MAX_HEIGHT_IN_CENTIMETER);
    }
}