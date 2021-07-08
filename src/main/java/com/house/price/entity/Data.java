package com.house.price.entity;

import java.util.List;

public class Data {
    private String border;  // 边界
    private List<PriceInfo> bubbleList;  // 数据List
    private int totalCount;   // 总共数量
    private int visibleCount;  // 可见数量

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public List<PriceInfo> getBubbleList() {
        return bubbleList;
    }

    public void setBubbleList(List<PriceInfo> bubbleList) {
        this.bubbleList = bubbleList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getVisibleCount() {
        return visibleCount;
    }

    public void setVisibleCount(int visibleCount) {
        this.visibleCount = visibleCount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "border='" + border + '\'' +
                ", bubbleList=" + bubbleList +
                ", totalCount=" + totalCount +
                ", visibleCount=" + visibleCount +
                '}';
    }
}