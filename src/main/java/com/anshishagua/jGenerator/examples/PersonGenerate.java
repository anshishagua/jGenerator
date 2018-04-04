package com.anshishagua.jGenerator.examples;

import com.anshishagua.jGenerator.ObjectGenerator;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午10:38
 */

public class PersonGenerate {
    public static void main(String [] args) {
        ObjectGenerator<Person> objectGenerator = new ObjectGenerator(Person.class);

        Person person = objectGenerator.generate();

        System.out.println(person);
    }
}