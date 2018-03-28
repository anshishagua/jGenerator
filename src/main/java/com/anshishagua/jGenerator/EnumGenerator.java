package com.anshishagua.jGenerator;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:08
 */

public class EnumGenerator<T extends Enum> implements Generator<T> {
    Class<T> clazz;

    public EnumGenerator(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T generate() {
        try {
            Random random = new Random();
            Method method =  clazz.getMethod("values");
            method.setAccessible(true);
            Object[] values = (Object[]) method.invoke(clazz, null);

            return (T) values[random.nextInt(values.length)];
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
