package com.house.price.task;

import com.house.price.common.CityEnum;
import com.house.price.service.HousePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TaskStater {

    @Autowired
    HousePriceService housePriceService;

    @Async
    void startTask() throws Exception {
        housePriceService.getCountyPriceList(CityEnum.NanJing.getCityId());
//        housePriceService.getCommunityPriceList(CityEnum.NanJing.getCityId(), );
    }

}
