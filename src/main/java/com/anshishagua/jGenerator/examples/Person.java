package com.anshishagua.jGenerator.examples;

import com.anshishagua.jGenerator.annotations.EnumConstraint;
import com.anshishagua.jGenerator.annotations.IntConstraint;
import com.anshishagua.jGenerator.annotations.StringConstraint;

/**
 * User: lixiao
 * Date: 2018/4/2
 * Time: 下午11:13
 */

public class Person {
    @StringConstraint(minLength = 3, maxLength = 5)
    private String name;

    @IntConstraint(min = 160, max = 170)
    private int height;

    @EnumConstraint()
    private Sex sex;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", sex=" + sex +
                '}';
    }
}