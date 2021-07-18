package com.house.price.entity;

public class CommonResponse<T> {

    private String errmsg;  // 错误消息
    private int errno;  // 错误编码
    private String reqId;   // 请求编码
    private String uniqId;  // 唯一编码
    private int cost; // 耗时
    private T data;  // 业务数据


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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "CommonResponse{" +
                "errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                ", reqId='" + reqId + '\'' +
                ", uniqId='" + uniqId + '\'' +
                ", cost=" + cost +
                ", data=" + data +
                '}';
    }
}
