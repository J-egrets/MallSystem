package cn.egret.dao.impl;

import cn.egret.dao.IOrderDao;
import cn.egret.entity.Order;
import cn.egret.util.JdbcUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public boolean addOrder(Order order) {
        String sql = "insert into t_order (id, userName, goodsId, count, status, orderTime, sendType, payType, totalPrice) values(?,?,?,?,?,?,?,?,?)";
        int flag = JdbcUtil.update(sql, order.getId(), order.getUserName(), order.getGoodsId(), order.getCount(), order.getStatus(), order.getOrderTime(), order.getSendType(), order.getPayType(), order.getTotalPrice());
        if (flag > 0) {
            System.out.println("添加订单成功");
            return true;
        } else {
            System.out.println("添加订单失败");
            return false;
        }
    }

    @Override
    public boolean deleteOrderById(String id) {
        String sql = "delete from t_order where id = ?";
        int flag = JdbcUtil.update(sql, id);
        if (flag > 0) {
            System.out.println("删除订单成功");
            return true;
        } else {
            System.out.println("删除订单失败");
            return false;
        }
    }

    @Override
    public boolean updateStatusById(int newStatus, String id) {
        String sql = "update t_order set status = ? where id = ?";
        int flag = JdbcUtil.update(sql, newStatus, id);
        if (flag > 0) {
            System.out.println("更新订单状态成功");
            return true;
        } else {
            System.out.println("更新订单状态失败");
            return false;
        }
    }

    @Override
    public List<Order> findOrderListByUserName(String userName, int curPage, int pageSize) {
        String sql = "select * from t_order where userName = ? limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<Order> orderList = JdbcUtil.queryAll(sql, Order.class, userName, curPage, pageSize);
        return orderList;
    }

    @Override
    public List<Order> findOrderList(int curPage, int pageSize) {
        String sql = "select * from t_order limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<Order> orderList = JdbcUtil.queryAll(sql, Order.class,curPage,pageSize);
        return orderList;
    }

    @Override
    public Order findOrderById(String id) {
        String sql = "select * from t_order where id = ?";
        List<Order> orderList = JdbcUtil.queryAll(sql, Order.class, id);
        Order order = null;
        for (Order o : orderList) {
            order = o;
        }
        return order;
    }

    @Override
    public int findGoodsStatusById(String id) {
        Order order = findOrderById(id);
        if (order != null) {
            return order.getStatus();
        } else {
            return -1;
        }
    }
}
