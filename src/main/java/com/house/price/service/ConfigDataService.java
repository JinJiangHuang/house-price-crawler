package com.house.price.service;

import com.house.price.entity.CityEntity;

import java.util.List;

/**
 * 配置数据服务
 */
public interface ConfigDataService {

    /**
     * 获取省份、地市配置数据
     * @throws Exception
     */
    List<CityEntity> getProvAndCityConfig() throws Exception;

}
