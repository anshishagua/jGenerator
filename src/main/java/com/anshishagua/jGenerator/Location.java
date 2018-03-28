package com.anshishagua.jGenerator;

/**
 * User: lixiao
 * Date: 2018/3/27
 * Time: 下午10:56
 */

public class Location {
    private String province;
    private String city;
    private String district;

    public Location(String province, String city, String district) {
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String discrict) {
        this.district = discrict;
    }

    @Override
    public String toString() {
        return "Location{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}