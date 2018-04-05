package com.anshishagua.jGenerator.examples;

import com.anshishagua.jGenerator.ObjectGenerator;
import com.anshishagua.jGenerator.datetime.DateGenerator;
import com.anshishagua.jGenerator.datetime.DateTimeGenerator;
import com.anshishagua.jGenerator.datetime.TimeGenerator;
import com.anshishagua.jGenerator.primitive.CharGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

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

        CharGenerator charGenerator = new CharGenerator();
        for (int i = 0; i < 10; ++i) {
            //System.out.println(charGenerator.generate());
            System.out.println(charGenerator.genLowerCaseLetter());
            System.out.println(charGenerator.genUpperCaseLetter());
            System.out.println(charGenerator.genDigit());
            System.out.println(charGenerator.genChineseLetter());
        }

        DateGenerator generator = new DateGenerator("2012-01-01", "2012-11-11");
        System.out.println(generator.generate());
        DateTimeGenerator dateTimeGenerator = new DateTimeGenerator("2012-01-01 11:00:00", "2012-01-31 11:00:00");
        System.out.println(dateTimeGenerator.generate());

        TimeGenerator timeGenerator = new TimeGenerator("11:11:11", "22:22:22");
        System.out.println(timeGenerator.generate());

        Class<?> a = Integer.class;

        System.out.println(a == Integer.class);

        Class b = Sex.class;

    }
}