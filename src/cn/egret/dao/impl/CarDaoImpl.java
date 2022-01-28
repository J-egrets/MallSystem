package cn.egret.dao.impl;

import cn.egret.dao.ICarDao;
import cn.egret.entity.Car;
import cn.egret.util.JdbcUtil;

import java.util.List;

public class CarDaoImpl implements ICarDao {
    @Override
    public boolean addCar(Car car) {
        String sql = "insert into t_car (userName,goodsId,goodsName,goodsImg,goodsPrice,number,totalPrice) values(?,?,?,?,?,?,?)";
        int flag = JdbcUtil.update(sql, car.getUserName(), car.getGoodsId(), car.getGoodsName(), car.getGoodsImg(), car.getGoodsPrice(),car.getNumber(), car.getTotalPrice());
        if (flag > 0) {
            System.out.println("添加购物车订单成功");
            return true;
        } else {
            System.out.println("添加购物车订单失败");
            return false;
        }
    }

    @Override
    public boolean deleteCarById(String userName, String goodsId, int carId) {
        String sql1 = "select * from t_car where userName = ? and goodsId = ?";
        List<Car> carList = JdbcUtil.queryAll(sql1,Car.class,userName,goodsId);
        String sql2 = "delete from t_car where userName =? and goodsId = ? and id = ?";
        int flag = JdbcUtil.update(sql2, userName, goodsId, carId);
        if (flag > 0) {
            System.out.println("删除购物车订单成功");
            return true;
        } else {
            System.out.println("删除购物车订单失败");
            return false;
        }
    }

    @Override
    public List<Car> findCarList(String userName, int curPage, int pageSize) {
        String sql = "select * from t_car where userName = ? limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<Car> carList = JdbcUtil.queryAll(sql, Car.class, userName, curPage, pageSize);
        return carList;
    }

    @Override
    public Car findCarById(int id) {
        String sql = "select * from t_car where id = ?";
        List<Car> carList = JdbcUtil.queryAll(sql,Car.class,id);
        Car car = null;
        for(Car c: carList){
            car = c;
        }
        return car;
    }

    @Override
    public boolean updateCarNumber(String userName, String goodsId, int newNumber) {
        String sql = "update t_car set number = ? where userName = ? and goodsId = ?";
        int flag = JdbcUtil.update(sql, newNumber, userName, goodsId);
        if (flag > 0) {
            System.out.println("更新购物车货品数量成功");
            return true;
        } else {
            System.out.println("更新购物车货品数量失败");
            return false;
        }
    }
}
