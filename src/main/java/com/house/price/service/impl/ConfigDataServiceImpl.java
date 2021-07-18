package com.house.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.house.price.common.URLAddress;
import com.house.price.entity.*;
import com.house.price.service.ConfigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置数据服务
 */
@Service
public class ConfigDataServiceImpl implements ConfigDataService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取省份、地市配置数据
     * @throws Exception
     */
    @Override
    public void getProvAndCityConfig() throws Exception {

        String url = URLAddress.PROV_CITY_CONFIG_URL;
        url += "?type={type}";
        url += "&category={category}";

        Map<String, Object> param = new HashMap<>();
        param.put("type", "province");
        param.put("category", 1);

//        CommonResponse<JSONObject> provCityData = restTemplate.getForObject(url, CommonResponse.class, param);
        ResponseEntity<CommonResponse> provCityData = restTemplate.getForEntity(url, CommonResponse.class, param);
        if(provCityData != null){
            CommonResponse commonResponse = provCityData.getBody();
            Map<String, HashMap> configMap = (HashMap) commonResponse.getData();
            System.out.println("configMap: " + configMap);

            // 遍历省份
            for (Map.Entry<String, HashMap> provEntry : configMap.entrySet()) {
                HashMap<String, HashMap> cityMapList = provEntry.getValue();

                // 地市遍历
                for (Map.Entry<String, HashMap> cityEntry : cityMapList.entrySet()) {
                    String cityId = cityEntry.getKey();
                    HashMap cityInfoMap = cityEntry.getValue();
//                    System.out.println("cityEntry: " + cityId + " - " + cityInfoMap);

                    CityEntity cityEntity = JSON.parseObject(JSON.toJSONString(cityInfoMap), CityEntity.class);
                    System.out.println("cityEntity: " + cityEntity);

                }

            }


        }
    }

}

