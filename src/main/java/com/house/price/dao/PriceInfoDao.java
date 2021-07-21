package com.house.price.dao;

import com.house.price.entity.PriceInfo;

import java.util.List;

public interface PriceInfoDao {

    /**
     * 增加价格信息
     */
    boolean addPriceInfo(PriceInfo priceInfo) throws Exception;

    /**
     * 批量增加房价信息
     */
    boolean addPriceInfo(List<PriceInfo> priceInfoList) throws Exception;

}
