package cn.egret.service;

import cn.egret.dao.ICarDao;
import cn.egret.dao.impl.CarDaoImpl;
import cn.egret.entity.Car;

import java.util.List;

public class CarService {
    private static ICarDao ICD = new CarDaoImpl();

    /**
     * 添加一个购物车订单
     *
     * @param car
     * @return
     */
    public static boolean addCar(Car car) {
        return ICD.addCar(car);
    }

    /**
     * 删除一个购物车订单
     *
     * @param userName
     * @param goodsId
     * @return
     */
    public static boolean deleteCar(String userName, String goodsId, int carId) {
        return ICD.deleteCarById(userName, goodsId, carId);
    }

    /**
     * 返回某用户的购物车列表
     *
     * @param userName
     * @return
     */
    public static List<Car> findCarList(String userName, int curPage, int pageSize) {
        return ICD.findCarList(userName, curPage, pageSize);
    }

    /**
     * 通过id查询一个购物车订单
     * @param id
     * @return
     */
    public static Car findCar(int id){
        return ICD.findCarById(id);
    }

    /**
     * 更新购物车货品数量
     *
     * @param userName
     * @param goodsId
     * @param newNumber
     * @return
     */
    public static boolean updateCarNumber(String userName, String goodsId, int newNumber) {
        return ICD.updateCarNumber(userName, goodsId, newNumber);
    }
}
