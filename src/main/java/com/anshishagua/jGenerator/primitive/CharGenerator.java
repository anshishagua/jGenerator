package com.anshishagua.jGenerator.primitive;

import com.anshishagua.jGenerator.AbstractGenerator;

import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 下午2:13
 */

public class CharGenerator extends AbstractGenerator<Character> {
    public CharGenerator(char min, char max) {
        super(min, max);
    }

    public CharGenerator() {
        super(Character.MIN_VALUE, Character.MAX_VALUE);
    }

    public char genDigit() {
        return (char) (new Random().nextInt(10) + '0');
    }

    public char genLowerCaseLetter() {
        return (char) (new Random().nextInt(26) + 'a');
    }

    public char genUpperCaseLetter() {
        return (char) (new Random().nextInt(26) + 'A');
    }

    public char genLetter() {
        char [] chars = new char[] {genLowerCaseLetter(), genUpperCaseLetter()};

        return chars[new Random().nextInt(1)];
    }

    public char genChineseLetter() {
        char min = '\u4E00';
        char max = '\u9FA5';

        int diff = max - min;

        return (char) (new Random().nextInt(diff) + min);
    }

    @Override
    public Character generate() {
        int diff = getUpperBound().charValue() - getLowerBound().charValue();


        return (char) (new Random().nextInt(diff) + getLowerBound().charValue());
    }
}