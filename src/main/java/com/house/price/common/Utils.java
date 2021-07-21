package com.house.price.common;

import com.house.price.entity.Matrix;
import com.house.price.entity.PriceInfo;
import org.apache.commons.lang3.StringUtils;

public class Utils {

    /**
     * 根据边界获取最大最小经纬度
     * @param priceInfo
     * @return
     * @throws Exception
     */
    public static Matrix getMaxBorder(PriceInfo priceInfo) throws Exception {
        double maxLongitude = 0d;
        double minLongitude = 0d;
        double maxLatitude = 0d;
        double minLatitude = 0d;

        String countryId = priceInfo.getId();
        String borderInfo = priceInfo.getBorder();
        String[] borderArr = StringUtils.split(borderInfo, ";");
        for(int i=0; i<borderArr.length; i++){
            String borderItem = borderArr[i];
            String[] borderItemArr = StringUtils.split(borderItem, ",");
            String currLongitude = borderItemArr[0];
            String currLatitude = borderItemArr[1];

            if(maxLongitude == 0d){
                maxLongitude = Double.valueOf(currLongitude);
            }
            if(minLongitude == 0d){
                minLongitude = Double.valueOf(currLongitude);
            }
            if(maxLatitude == 0d){
                maxLatitude = Double.valueOf(currLatitude);
            }
            if(minLatitude == 0d){
                minLatitude = Double.valueOf(currLatitude);
            }

            if(Double.valueOf(currLongitude) > maxLongitude){
                maxLongitude = Double.valueOf(currLongitude);
            }
            if(Double.valueOf(currLongitude) < minLongitude){
                minLongitude = Double.valueOf(currLongitude);
            }
            if(Double.valueOf(currLatitude) > maxLatitude){
                maxLatitude = Double.valueOf(currLatitude);
            }
            if(Double.valueOf(currLatitude) < minLatitude){
                minLatitude = Double.valueOf(currLatitude);
            }
        }
        Matrix matrix = new Matrix(countryId, String.valueOf(maxLatitude), String.valueOf(minLatitude),
                String.valueOf(maxLongitude), String.valueOf(minLongitude));

        return matrix;
    }

}
