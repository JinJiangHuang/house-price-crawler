package com.house.price.service.impl;

import com.house.price.common.City;
import com.house.price.common.StaticValue;
import com.house.price.common.URLAddress;
import com.house.price.entity.Data;
import com.house.price.entity.PriceInfo;
import com.house.price.entity.PriceResponse;
import com.house.price.service.HousePriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市房价-二手房
 */
@Service
public class HousePriceServiceImpl implements HousePriceService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    /**
     * 获取区县房价信息
     * @throws Exception
     */
    @Override
    public void getCountyPriceList(String cityId) throws Exception {
        String url = URLAddress.URL;
        url += "?cityId={cityId}";
        url += "&dataSource={dataSource}";
        url += "&groupType={groupType}";
        url += "&maxLatitude={maxLatitude}";
        url += "&minLatitude={minLatitude}";
        url += "&maxLongitude={maxLongitude}";
        url += "&minLongitude={minLongitude}";

        Map<String, Object> param = new HashMap<>();
        param.put("cityId", cityId);
        param.put("dataSource", "ESF");
        param.put("groupType", StaticValue.groupType_district);
        param.put("maxLatitude", "32.306399256054924");
        param.put("minLatitude", "31.937478334965306");
        param.put("maxLongitude", "119.16571969714943");
        param.put("minLongitude", "118.44017630285043");
        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if(priceResponse != null && priceResponse.getErrno() == 0){
            Data data = priceResponse.getData();
            List<PriceInfo> priceInfoList = data.getBubbleList();
        }

        System.out.println(priceResponse);
    }

    /**
     * 获取区县下一级房价信息
     * 比如将军大道
     * @throws Exception
     */
    @Override
    public void getStreetPriceList(String cityId, String countyId) throws Exception {
        String url = URLAddress.URL;
        url += "?cityId={cityId}";
        url += "&dataSource={dataSource}";
        url += "&groupType={groupType}";
        url += "&maxLatitude={maxLatitude}";
        url += "&minLatitude={minLatitude}";
        url += "&maxLongitude={maxLongitude}";
        url += "&minLongitude={minLongitude}";

        Map<String, String> param = new HashMap<>();
        param.put("cityId", "320100");
        param.put("dataSource", "ESF");
        param.put("groupType", StaticValue.groupType_bizcircle);
        param.put("maxLatitude", "31.997618837494954");
        param.put("minLatitude", "31.90521473322665");
        param.put("maxLongitude", "118.97391639753731");
        param.put("minLongitude", "118.79253054896256");

        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if(priceResponse != null && priceResponse.getErrno() == 0){
            Data data = priceResponse.getData();
            List<PriceInfo> priceInfoList = data.getBubbleList();
        }

        System.out.println(priceResponse);
    }

    /**
     * 获取所有区县下一级房价信息
     * @param cityId
     * @throws Exception
     */
    @Override
    public void getAllStreetPrice(String cityId) throws Exception {
        List<String> countyList = City.countyList;
        for(String countyId : countyList){
            getStreetPriceList(cityId, countyId);
        }
    }

    /**
     * 获取小区房价信息
     * 比如滟紫台
     * @throws Exception
     */
    @Override
    public void getCommunityPriceList(String cityId, String streetId, String communityId) throws Exception {
        String url = URLAddress.URL;
        url += "?cityId={cityId}";
        url += "&dataSource={dataSource}";
        url += "&groupType={groupType}";
        url += "&maxLatitude={maxLatitude}";
        url += "&minLatitude={minLatitude}";
        url += "&maxLongitude={maxLongitude}";
        url += "&minLongitude={minLongitude}";

        Map<String, String> param = new HashMap<>();
        param.put("cityId", "320100");
        param.put("dataSource", "ESF");
        param.put("groupType", StaticValue.groupType_community);
        param.put("maxLatitude", "31.96182992719362");
        param.put("minLatitude", "31.938728608086027");
        param.put("maxLongitude", "118.81058273107178");
        param.put("minLongitude", "118.76523626892809");

        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if(priceResponse != null && priceResponse.getErrno() == 0){
            Data data = priceResponse.getData();
            List<PriceInfo> priceInfoList = data.getBubbleList();
        }

        System.out.println(priceResponse);
    }

    /**
     * 获取某个街道所有小区房价信息
     * @param cityId
     * @param countyId
     * @throws Exception
     */
    @Override
    public void getAllCommunityPrice(String cityId, String countyId) throws Exception {
//        List<String> countyList = City.countyList;
//        for(String countyId : countyList){
//            getStreetPriceList(cityId, countyId);
//        }
        String communityId = "";
        getCommunityPriceList(cityId, countyId, communityId);
    }
}
