package com.house.price.entity;

public class Matrix {
    private String id; // 最大纬度
    private String maxLatitude; // 最大纬度
    private String minLatitude; // 最小纬度
    private String maxLongitude; // 最大经度
    private String minLongitude; // 最小经度

    public Matrix(String id, String maxLatitude, String minLatitude, String maxLongitude, String minLongitude) {
        this.id = id;
        this.maxLatitude = maxLatitude;
        this.minLatitude = minLatitude;
        this.maxLongitude = maxLongitude;
        this.minLongitude = minLongitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(String maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public String getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(String minLatitude) {
        this.minLatitude = minLatitude;
    }

    public String getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(String maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public String getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(String minLongitude) {
        this.minLongitude = minLongitude;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "maxLatitude='" + maxLatitude + '\'' +
                ", minLatitude='" + minLatitude + '\'' +
                ", maxLongitude='" + maxLongitude + '\'' +
                ", minLongitude='" + minLongitude + '\'' +
                '}';
    }
}
