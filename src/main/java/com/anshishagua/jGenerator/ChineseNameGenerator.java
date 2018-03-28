package com.anshishagua.jGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:47
 */

public class ChineseNameGenerator extends StringGenerator {
    private static final String FILE_NAME = "chineseNames.txt";
    private static final Map<Integer, List<String>> NAME_MAP = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ChineseNameGenerator.class.getClassLoader().getResourceAsStream(FILE_NAME)))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String name = line.split(" ")[1].trim();

                if (!NAME_MAP.containsKey(name.length())) {
                    NAME_MAP.put(name.length(), new ArrayList<>());
                }

                NAME_MAP.get(name.length()).add(name);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ChineseNameGenerator() {
        super(1, 5);
    }

    public ChineseNameGenerator(int minLength, int maxLength) {
        super(minLength, maxLength);
    }

    @Override
    public String generate() {
        List<Integer> list = new ArrayList<>(NAME_MAP.keySet());

        int i = list.get(new Random().nextInt(list.size()));

        List<String> names = NAME_MAP.get(i);

        i = new Random().nextInt(names.size());

        return names.get(i);
    }

    public static void main(String [] args) {
        ChineseNameGenerator generator = new ChineseNameGenerator();

        for (int i = 0; i < 10; ++i) {
            System.out.println(generator.generate());
        }
    }
}
