package com.house.price.service.impl;

import com.house.price.common.CityEnum;
import com.house.price.service.HousePriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试城市房价-二手房
 */
@SpringBootTest
public class HousePriceServiceImplTest {

    @Autowired
    HousePriceService housePriceService;

    /**
     * 获取区县房价信息
     * @throws Exception
     */
    @Test
    void testGetCountyPriceList() throws Exception {
//        String cityId = CityEnum.NanJing.getCityId();
//        housePriceService.getCountyPriceList(cityId);
    }

    /**
     * 获取区县下一级房价信息
     * @throws Exception
     */
    @Test
    void testGetStreetPriceList() throws Exception {
        String cityId = CityEnum.NanJing.getCityId();
//        housePriceService.getStreetPriceList(cityId, "");
    }

    /**
     * 获取小区房价信息
     * @throws Exception
     */
    @Test
    void testGetCommunityPriceList() throws Exception {
        String cityId = CityEnum.NanJing.getCityId();
//        housePriceService.getCommunityPriceList(cityId, "", "");
    }

}
