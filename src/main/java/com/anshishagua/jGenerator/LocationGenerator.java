package com.anshishagua.jGenerator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
 * Date: 2018/3/28
 * Time: 下午3:13
 */

public class LocationGenerator implements Generator<Location> {
    private static final String LOCATION_DATA_FILE = "locations.json";
    private static final List<Map<String, List<Map<String, List<String>>>>> LOCATION_DATA = new ArrayList<>();

    private static void buildLocationMap() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(LocationGenerator.class.getClassLoader().getResourceAsStream(LOCATION_DATA_FILE)))) {

            StringBuilder builder = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }

            JSONArray object = JSON.parseArray(builder.toString());
            for (int i = 0; i < object.size(); ++i) {
                JSONObject jsonObject = (JSONObject) object.get(i);

                String province = jsonObject.getString("name");

                Map<String, List<Map<String, List<String>>>> provinceMap = new HashMap<>();
                provinceMap.put(province, new ArrayList<>());

                JSONArray cities = jsonObject.getJSONArray("city");

                for (int j = 0; j < cities.size(); ++j) {
                    JSONObject cityObject = (JSONObject) cities.get(j);

                    Map<String, List<String>> cityMap = new HashMap<>();
                    String city = cityObject.getString("name");

                    if ("其他".equals(city)) {
                        continue;
                    }

                    List<String> districts = new ArrayList<>();

                    JSONArray areas = cityObject.getJSONArray("area");

                    for (int k = 0; k < areas.size(); ++k) {
                        String district = areas.getString(k);

                        if ("其他".equals(district)) {
                            continue;
                        }

                        districts.add(district);
                    }

                    cityMap.put(city, districts);

                    provinceMap.get(province).add(cityMap);
                }

                LOCATION_DATA.add(provinceMap);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static {
        buildLocationMap();
    }

    @Override
    public Location generate() {
        String province = null;
        String city = null;
        String district = null;

        Random random = new Random();

        int i = random.nextInt(LOCATION_DATA.size());
        province = LOCATION_DATA.get(i).keySet().iterator().next();

        List<Map<String, List<String>>> cities = LOCATION_DATA.get(i).get(province);

        i = random.nextInt(cities.size());
        city = cities.get(i).keySet().iterator().next();

        List<String> districts = cities.get(i).get(city);

        i = random.nextInt(districts.size());
        district = districts.get(i);

        return new Location(province, city, district);
    }

    public static void main(String [] args) {
        LocationGenerator generator = new LocationGenerator();

        for (int i = 0; i < 10; ++i) {
            System.out.println(generator.generate());
        }
    }
}

