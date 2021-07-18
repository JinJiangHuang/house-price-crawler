package com.house.price.entity;

public class CityEntity {

    private String id;
    private String name;
    private String host;
    private String mobile_host;
//    private String short;
    private String province;
    private String province_short;
    private String pinyin;
    private String longitude;
    private String latitude;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMobile_host() {
        return mobile_host;
    }

    public void setMobile_host(String mobile_host) {
        this.mobile_host = mobile_host;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince_short() {
        return province_short;
    }

    public void setProvince_short(String province_short) {
        this.province_short = province_short;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", mobile_host='" + mobile_host + '\'' +
                ", province='" + province + '\'' +
                ", province_short='" + province_short + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
