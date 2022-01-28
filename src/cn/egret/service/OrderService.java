package cn.egret.service;

import cn.egret.dao.IGoodsDao;
import cn.egret.dao.IOrderDao;
import cn.egret.dao.impl.GoodsDaoImpl;
import cn.egret.dao.impl.OrderDaoImpl;
import cn.egret.entity.Order;

import java.util.List;

public class OrderService {
    private static IOrderDao IOD = new OrderDaoImpl();
    private static IGoodsDao IGD = new GoodsDaoImpl();

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    public static boolean addOrder(Order order) {
        return IOD.addOrder(order);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    public static boolean deleteOrder(String id) {
        return IOD.deleteOrderById(id);
    }

    /**
     * 修改订单状态  0表示审核中  1表示通过  2表示未通过
     *
     * @param newStatus
     * @param id
     * @return
     */
    public static boolean changeStatus(int newStatus, String id) {
        Order order = IOD.findOrderById(id);
        if (order.getStatus() == 0 && newStatus == 1) {
            // 如果订单通过，那么库存减去相应的数据
            IGD.updateGoodsCountById(IGD.findGoodsCountById(order.getGoodsId()) - order.getCount(), order.getGoodsId());
        }

        return IOD.updateStatusById(newStatus, id);
    }

    /**
     * 查询某用户的所有订单
     * @param userName
     * @param curPage
     * @param pageSize
     * @return
     */
    public static List<Order> findOrderList(String userName, int curPage, int pageSize) {
        return IOD.findOrderListByUserName(userName, curPage, pageSize);
    }

    /**
     * 查询所有用户的订单
     *
     * @return
     */
    public static List<Order> findOrderList(int curPage, int pageSize) {
        return IOD.findOrderList(curPage, pageSize);
    }
}
