package com.anshishagua.jGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/29
 * Time: 上午9:39
 */

public class BooleanGenerator implements Generator<Boolean> {
    @Override
    public Boolean generate() {
        Random random = new Random();

        return random.nextInt(1) == 1;
    }
}