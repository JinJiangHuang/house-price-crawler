package com.house.price.service.impl;

import com.house.price.common.CityEnum;
import com.house.price.entity.CityEntity;
import com.house.price.service.ConfigDataService;
import com.house.price.service.HousePriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConfigDataServiceImplTest {

    @Autowired
    ConfigDataService configDataService;

    /**
     * 获取区县房价信息
     * @throws Exception
     */
    @Test
    void testGetCountyPriceList() throws Exception {
        List<CityEntity> cityList = configDataService.getProvAndCityConfig();
        System.out.println("cityList: " + cityList);
    }


}
