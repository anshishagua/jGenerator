package com.anshishagua.jGenerator.examples;

import com.anshishagua.jGenerator.annotations.EnumGenerate;
import com.anshishagua.jGenerator.annotations.Generate;
import com.anshishagua.jGenerator.annotations.IntGenerate;
import com.anshishagua.jGenerator.annotations.Size;
import com.anshishagua.jGenerator.annotations.StringGenerate;

import java.util.List;

/**
 * User: lixiao
 * Date: 2018/4/2
 * Time: 下午11:13
 */

public class Person {
    @StringGenerate(minLength = 3, maxLength = 5)
    private String name;

    @IntGenerate(min = 160, max = 170)
    private int height;

    @EnumGenerate()
    private Sex sex;

    @Generate
    private Address address;

    @Size(value = 100)
    List<Address> addresses;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", sex=" + sex +
                ", address=" + address +
                ", addresses=" + addresses +
                '}';
    }
}