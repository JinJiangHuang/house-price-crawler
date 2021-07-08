package com.house.price.entity;

import java.util.List;

public class PriceResponse {

    private int cost; // 耗时
    private Data data;  // 价格数据列表
    private String errmsg;  // 错误消息
    private int errno;  // 错误编码
    private String reqId;   // 请求编码
    private String uniqId;  // 唯一编码

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }


    @Override
    public String toString() {
        return "PriceResponse{" +
                "cost=" + cost +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                ", reqId='" + reqId + '\'' +
                ", uniqId='" + uniqId + '\'' +
                '}';
    }


}
