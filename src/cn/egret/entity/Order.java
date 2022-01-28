package cn.egret.entity;

import cn.egret.service.GoodsService;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;
    private String userName;
    private String goodsId;
    private int count;
    private int status;
    private Date orderTime;
    private String sendType;
    private String payType;
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(String id, String userName, String goodsId, int count, int status, Date orderTime, String sendType, String payType, BigDecimal totalPrice) {
        this.id = id;
        this.userName = userName;
        this.goodsId = goodsId;
        this.count = count;
        this.status = status;
        this.orderTime = orderTime;
        this.sendType = sendType;
        this.payType = payType;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsName() {
        return GoodsService.findGoods(this.goodsId).getName();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", count=" + count +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", sendType='" + sendType + '\'' +
                ", payType='" + payType + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
