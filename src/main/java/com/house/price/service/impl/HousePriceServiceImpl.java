package com.house.price.service.impl;

import com.house.price.common.RegionData;
import com.house.price.common.StaticValue;
import com.house.price.common.URLAddress;
import com.house.price.dao.PriceInfoDao;
import com.house.price.entity.*;
import com.house.price.service.HousePriceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * 城市房价-二手房
 */
@Service
public class HousePriceServiceImpl implements HousePriceService {

    private static final Log LOG = LogFactory.getLog(HousePriceServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    PriceInfoDao priceInfoDao;


    /**
     * 获取区县房价信息
     *
     * @throws Exception
     */
    @Override
    public List<PriceInfo> getCountyPriceList(CityEntity cityEntity) throws Exception {
        List<PriceInfo> priceInfoList = new ArrayList<>();

        String url = URLAddress.PRICE_URL;
        url += "?cityId={cityId}";
        url += "&dataSource={dataSource}";
        url += "&groupType={groupType}";
        url += "&maxLatitude={maxLatitude}";
        url += "&minLatitude={minLatitude}";
        url += "&maxLongitude={maxLongitude}";
        url += "&minLongitude={minLongitude}";

        Map<String, Object> param = new HashMap<>();
        param.put("cityId", cityEntity.getId());
        param.put("dataSource", "ESF");
        param.put("groupType", StaticValue.groupType_district);

        Matrix matrix = RegionData.cityMappingList.get(cityEntity.getId());
        if (matrix == null) {
            return priceInfoList;
        }
        param.put("maxLatitude", matrix.getMaxLatitude());
        param.put("minLatitude", matrix.getMinLatitude());
        param.put("maxLongitude", matrix.getMaxLongitude());
        param.put("minLongitude", matrix.getMinLongitude());

        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if (priceResponse != null && priceResponse.getErrno() == 0) {
            Data data = priceResponse.getData();
            priceInfoList = data.getBubbleList();
        }

        return priceInfoList;
    }

    /**
     * 获取区县下一级房价信息
     * 比如将军大道
     *
     * @throws Exception
     */
    @Override
    public List<PriceInfo> getStreetPriceList(String cityId, String countyId, Matrix matrix) throws Exception {
        List<PriceInfo> priceInfoList = new ArrayList<>();

        String url = URLAddress.PRICE_URL;
        url += "?cityId={cityId}";
        url += "&dataSource={dataSource}";
        url += "&groupType={groupType}";
        url += "&maxLatitude={maxLatitude}";
        url += "&minLatitude={minLatitude}";
        url += "&maxLongitude={maxLongitude}";
        url += "&minLongitude={minLongitude}";

        Map<String, String> param = new HashMap<>();
        param.put("cityId", cityId);
        param.put("dataSource", "ESF");
        param.put("groupType", StaticValue.groupType_bizcircle);

        // 优先使用手动维护数据
        Matrix countryMatrix = RegionData.cityMappingList.get(countyId);
        if (countryMatrix == null) {
            countryMatrix = matrix;
        }

        param.put("maxLatitude", countryMatrix.getMaxLatitude());
        param.put("minLatitude", countryMatrix.getMinLatitude());
        param.put("maxLongitude", countryMatrix.getMaxLongitude());
        param.put("minLongitude", countryMatrix.getMinLongitude());

        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if (priceResponse != null && priceResponse.getErrno() == 0) {
            Data data = priceResponse.getData();
            priceInfoList = data.getBubbleList();
        }
        return priceInfoList;
    }


    /**
     * 获取小区房价信息
     * 比如滟紫台
     *
     * @throws Exception
     */
    @Override
    public List<PriceInfo> getCommunityPriceList(String cityId, String streetId, String communityId, Matrix matrix) throws Exception {
        List<PriceInfo> priceInfoList = new ArrayList<>();
        String url = URLAddress.PRICE_URL;
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

        param.put("maxLatitude", matrix.getMaxLatitude());
        param.put("minLatitude", matrix.getMinLatitude());
        param.put("maxLongitude", matrix.getMaxLongitude());
        param.put("minLongitude", matrix.getMinLongitude());

        PriceResponse priceResponse = restTemplate.getForObject(url, PriceResponse.class, param);
        if (priceResponse != null && priceResponse.getErrno() == 0) {
            Data data = priceResponse.getData();
            priceInfoList = data.getBubbleList();
        }

        return priceInfoList;
    }

    /**
     * 增加价格信息
     */
    @Override
    public boolean addPriceInfo(PriceInfo priceInfo) {
        boolean result = false;
        try {
            boolean isExist = priceInfoDao.isExist(priceInfo.getExecuteDate(), priceInfo.getType(), priceInfo.getId());
            if (isExist) {
                LOG.warn("priceInfo exist: " + priceInfo.getId());
            } else {
                result = priceInfoDao.addPriceInfo(priceInfo);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    /**
     * 批量增加房价信息
     */
    @Override
    public boolean addPriceInfo(List<PriceInfo> priceInfoList) {
        boolean result = false;
        try {
            List<PriceInfo> tempPriceInfoList = new ArrayList<>(priceInfoList);
            for (int i = tempPriceInfoList.size() - 1; i >= 0; i--) {
                PriceInfo priceInfoItem = tempPriceInfoList.get(i);
                boolean isExist = priceInfoDao.isExist(priceInfoItem.getExecuteDate(), priceInfoItem.getType(), priceInfoItem.getId());
                if (isExist) {
                    tempPriceInfoList.remove(priceInfoItem);
                }
            }
            if(tempPriceInfoList != null && tempPriceInfoList.size() > 0){
                result = priceInfoDao.addPriceInfo(tempPriceInfoList);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    /**
     * 判断数据是否存在
     *
     * @param executeDate
     * @param priceType
     * @param priceId
     * @return
     */
    @Override
    public boolean isExist(String executeDate, String priceType, String priceId) {
        boolean result = false;
        try {
            result = priceInfoDao.isExist(executeDate, priceType, priceId);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

}
