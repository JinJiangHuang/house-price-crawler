package com.house.price.dao.impl;

import com.house.price.common.DateUtil;
import com.house.price.dao.PriceInfoDao;
import com.house.price.entity.PriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PriceInfoDaoImpl implements PriceInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<PriceInfo> rowMapper = BeanPropertyRowMapper.newInstance(PriceInfo.class);

    /**
     * 增加房价信息
     *
     * @param priceInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean addPriceInfo(PriceInfo priceInfo) throws Exception {
        String executeDate = DateUtil.getYYYYMMDD();

        String sql = "insert into t_price_info(execute_date, price_type, id, name, full_spell, longitude, latitude, price, price_unit, price_str, desc, image_type, icon, " +
                "count, count_unit, count_str, entity_id, entity_type, border, bubble_desc, selected) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, new Object[]{executeDate, priceInfo.getType(), priceInfo.getId(), priceInfo.getName(),
                priceInfo.getFullSpell(), priceInfo.getLongitude(), priceInfo.getLatitude(), priceInfo.getPrice(),
                priceInfo.getPriceUnit(), priceInfo.getPriceStr(), priceInfo.getDesc(), priceInfo.getImageType(),
                priceInfo.getIcon(), priceInfo.getCount(), priceInfo.getCountUnit(), priceInfo.getCountStr(),
                priceInfo.getEntityId(), priceInfo.getEntityType(), priceInfo.getBorder(), priceInfo.getBubbleDesc(),
                priceInfo.getSelected()});
        return result == 1;
    }

    /**
     * 批量增加房价信息
     * @param priceInfoList
     * @return
     * @throws Exception
     */
    @Override
    public boolean addPriceInfo(List<PriceInfo> priceInfoList) throws Exception {
        String executeDate = DateUtil.getYYYYMMDD();
        String sql = "insert into t_price_info(execute_date, id, name, full_spell, longitude, latitude, price, price_unit, price_str, descx, image_type, icon, " +
                "count, count_unit, count_str, entity_id, entity_type, border, bubble_desc, selected, price_type) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, executeDate);
                ps.setString(2, priceInfoList.get(i).getId());
                ps.setString(3, priceInfoList.get(i).getName());
                ps.setString(4, priceInfoList.get(i).getFullSpell());
                ps.setString(5, priceInfoList.get(i).getLongitude());
                ps.setString(6, priceInfoList.get(i).getLatitude());
                ps.setString(7, priceInfoList.get(i).getPrice());
                ps.setString(8, priceInfoList.get(i).getPriceUnit());
                ps.setString(9, priceInfoList.get(i).getPriceStr());
                ps.setString(10, priceInfoList.get(i).getDesc());
                ps.setString(11, priceInfoList.get(i).getImageType());
                ps.setString(12, priceInfoList.get(i).getIcon());
                ps.setString(13, priceInfoList.get(i).getCount());
                ps.setString(14, priceInfoList.get(i).getCountUnit());
                ps.setString(15, priceInfoList.get(i).getCountStr());
                ps.setString(16, priceInfoList.get(i).getEntityId());
                ps.setString(17, priceInfoList.get(i).getEntityType());
                ps.setString(18, priceInfoList.get(i).getBorder());
                ps.setString(19, priceInfoList.get(i).getBubbleDesc());
                ps.setString(20, priceInfoList.get(i).getSelected());
                ps.setString(21, priceInfoList.get(i).getType());
            }

            public int getBatchSize() {
                return priceInfoList.size();
            }

        });
        return true;
    }


}
