package cn.egret.entity;

import cn.egret.dao.IGoodsDao;
import cn.egret.dao.impl.GoodsDaoImpl;

import java.math.BigDecimal;

public class Car {
    private int id;
    private String userName;
    private String goodsId;
    private String goodsName;
    private String goodsImg;
    private BigDecimal goodsPrice;
    private int number;
    private BigDecimal totalPrice;

    public Car() {
    }

    public Car(String userName, String goodsId, String goodsName, String goodsImg, BigDecimal goodsPrice, int number) {
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.number = number;
        IGoodsDao IGD = new GoodsDaoImpl();
        Goods goods = IGD.findGoodsById(this.goodsId);
        this.totalPrice = goods.getPrice().multiply(new BigDecimal(this.number));
    }

    public Car(String userName, String goodsId, String goodsName, String goodsImg, int number) {
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.number = number;
        IGoodsDao IGD = new GoodsDaoImpl();
        Goods goods = IGD.findGoodsById(this.goodsId);
        this.totalPrice = goods.getPrice().multiply(new BigDecimal(this.number));
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        IGoodsDao IGD = new GoodsDaoImpl();
        Goods goods = IGD.findGoodsById(this.goodsId);
        this.totalPrice = goods.getPrice().multiply(new BigDecimal(this.number));
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
