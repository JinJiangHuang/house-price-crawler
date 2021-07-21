package com.house.price.dao;

import com.house.price.entity.PriceInfo;

import java.util.List;

public interface PriceInfoRepository {

    Iterable<PriceInfo> findAll();

    PriceInfo findOne(String id);

    PriceInfo save(PriceInfo Book);

    boolean save(List<PriceInfo> Book);

}
