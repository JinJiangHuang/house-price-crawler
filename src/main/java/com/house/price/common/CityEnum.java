package com.house.price.common;

public enum CityEnum {
    NanJing("南京", "320100"),
    ShangHai("上海", "2");

    private String cityName;
    private String cityId;

    // 构造方法
    private CityEnum(String cityName, String cityId) {
        this.cityName = cityName; this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.cityId + "_" + this.cityName;

    }

}
