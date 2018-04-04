package com.anshishagua.jGenerator.examples;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:35
 */

public enum Sex {
    FEMALE("女"),
    MALE("男");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
