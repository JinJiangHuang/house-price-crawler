package com.house.price.common;

public class URLAddress {

    private static String CONFIG_URL = "https://ajax.api.lianjia.com";


    // 请求省份、地市配置数据
    public static String PROV_CITY_CONFIG_URL = CONFIG_URL + "/config/cityConfig/getConfig";

    // 查询区县数据

    // 查询房价信息
    public static String PRICE_URL = "https://map.ke.com/proxyApi/i.c-pc-webapi.ke.com/map/bubblelist";
    //?cityId=320100&dataSource=ESF&condition=&id=&groupType=district
    // &maxLatitude=32.306399256054924&minLatitude=31.937478334965306&maxLongitude=119.16571969714943&minLongitude=118.44017630285043


}
