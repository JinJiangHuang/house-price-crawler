package com.house.price.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {

    /**
     * 城市列表
     * 南京      320100
     *         param.put("maxLatitude", "32.306399256054924");
     *         param.put("minLatitude", "31.937478334965306");
     *         param.put("maxLongitude", "119.16571969714943");
     *         param.put("minLongitude", "118.44017630285043");
     * 玄武区	320102
     * 秦淮区	320104
     * 建邺区	320105
     * 鼓楼区	320106
     * 浦口区	320111
     * 栖霞区	320113
     * 雨花台区  320114
     * 江宁区	320115
     *          &maxLatitude=31.997618837494954
     *          &minLatitude=31.90521473322665
     *          &maxLongitude=118.97391639753731
     *          &minLongitude=118.79253054896256
     *     将军大道
     *     &maxLatitude=31.96182992719362
     *     &minLatitude=31.938728608086027
     *     &maxLongitude=118.81058273107178
     *     &minLongitude=118.76523626892809
     *
     * 六合区	320116
     * 溧水区	320124
     * 高淳区	320125
     */
    public static final List<String> cityList = new ArrayList<>(
            Arrays.asList("320100")
    );

    /**
     * 区县列表
     */
    public static final List<String> countyList = new ArrayList<>(
            Arrays.asList("320102",
                    "320104",
                    "320105",
                    "320106",
                    "320111",
                    "320113",
                    "320114",
                    "320115",
                    "320116",
                    "320124",
                    "320125")
    );

}
