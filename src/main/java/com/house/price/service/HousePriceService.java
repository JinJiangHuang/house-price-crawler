package com.house.price.service;

import com.house.price.entity.CityEntity;
import com.house.price.entity.Matrix;
import com.house.price.entity.PriceInfo;

import java.util.List;

/**
 * 城市房价-二手房
 */
public interface HousePriceService {

    /**
     * 获取区县房价信息
     * 比如江宁区
     *
     * @throws Exception
     */
    List<PriceInfo> getCountyPriceList(CityEntity cityEntity) throws Exception;


    /**
     * 获取区县下一级房价信息
     * 比如将军大道
     *
     * @throws Exception
     */
    List<PriceInfo> getStreetPriceList(String cityId, String countyId, Matrix matrix) throws Exception;

    /**
     * 获取小区房价信息
     * 比如滟紫台
     *
     * @throws Exception
     */
    List<PriceInfo> getCommunityPriceList(String cityId, String streetId, String communityId, Matrix matrix) throws Exception;


    /**
     * 增加价格信息
     */
    boolean addPriceInfo(PriceInfo priceInfo);

    /**
     * 批量增加房价信息
     */
    boolean addPriceInfo(List<PriceInfo> priceInfoList);

}
