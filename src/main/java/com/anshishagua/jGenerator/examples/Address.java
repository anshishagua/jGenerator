package com.anshishagua.jGenerator.examples;

import com.anshishagua.jGenerator.annotations.Generate;
import com.anshishagua.jGenerator.annotations.StringGenerate;

/**
 * User: lixiao
 * Date: 2018/4/5
 * Time: 下午11:10
 */

@Generate
public class Address {
    @StringGenerate(minLength = 3, maxLength = 5)
    private String country;
    @StringGenerate(minLength = 4, maxLength = 7)
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}