package com.anshishagua.jGenerator;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.time.LocalDate;

/**
 * User: lixiao
 * Date: 2018/3/28
 * Time: 下午11:26
 */

public class DateGeneratorTest extends TestCase {
    public void testDateGenerate() {
        DateGenerator generator = new DateGenerator("2011-01-01", "2011-12-31");

        LocalDate localDate = generator.generate();

        System.out.println(localDate);
        Assert.assertTrue(localDate.compareTo(generator.getMin()) >= 0 && localDate.compareTo(generator.getMax()) <= 0);
    }
}