package cn.egret.dao;

import cn.egret.entity.Car;

import java.util.List;

public interface ICarDao {

    boolean addCar(Car car); // 添加一个购物车订单

    boolean deleteCarById(String userName, String goodsId, int carId); // 删除一个购物车订单

    List<Car> findCarList(String userName, int curPage, int pageSize); // 查询用户购物车列表

    Car findCarById(int id); // 查询一个购物车订单

    boolean updateCarNumber(String userName, String goodsId, int newNumber); // 更新货品数量

}
