package cn.egret.dao;

import cn.egret.entity.Order;

import java.util.List;

public interface IOrderDao {

    boolean addOrder(Order order); // 增加订单

    boolean deleteOrderById(String id); // 通过id删除订单

    boolean updateStatusById(int newStatus, String id); // 通过id修改订单状态

    List<Order> findOrderListByUserName(String userName,int curPage, int pageSize); // 通过用户名查询此用户所有订单

    List<Order> findOrderList(int curPage, int pageSize); // 查询所有订单

    Order findOrderById(String id); // 通过Id查询订单

    int findGoodsStatusById(String id); // 获取订单状态
}
