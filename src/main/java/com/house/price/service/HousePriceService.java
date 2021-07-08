package com.house.price.service;

/**
 * 城市房价-二手房
 */
public interface HousePriceService {

    /**
     * 获取区县房价信息
     * 比如江宁区
     * @throws Exception
     */
    void getCountyPriceList(String cityId) throws Exception;


    /**
     * 获取区县下一级房价信息
     * 比如将军大道
     * @throws Exception
     */
    void getStreetPriceList(String cityId, String countyId) throws Exception;

    /**
     * 获取小区房价信息
     * 比如滟紫台
     * @throws Exception
     */
    void getCommunityPriceList(String cityId, String streetId) throws Exception;
}
