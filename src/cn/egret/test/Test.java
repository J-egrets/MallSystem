package cn.egret.test;

import cn.egret.dao.*;
import cn.egret.dao.impl.*;
import cn.egret.entity.Goods;
import cn.egret.entity.GoodsCategories;
import cn.egret.entity.Order;
import cn.egret.entity.User;
import cn.egret.util.JdbcUtil;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        IUserDao IUD = new UserDaoImpl();
//        User user = new User("1","1","男","22","北京",0,1);
//        IUD.addUser(user);

//        User u = IUD.findUserByNP("admin","2");
//        System.out.println(u);

//        IUD.updatePasswordByUserName("张三","2");

//        List<User> userList = IUD.findUserList(1);
//        System.out.println(userList);

//        IUD.updateUserStateByName("张三",1);
//        IUD.deleteUserByName("1");

        IGoodsCategoriesDao ICD = new GoodsCategoriesDaoImpl();
//        GoodsCategories gc = new GoodsCategories("000","测试");
//        ICD.addCategory(gc);

//        System.out.println(ICD.findIdByName("电器"));
//        System.out.println(ICD.findNameById("000"));

//        ICD.deleteCategoryById("000");

        IGoodsDao IGD = new GoodsDaoImpl();
//        Goods goods = new Goods("000","测试","cecececece",new BigDecimal("22"),"111",0,0);
//        IGD.addGoods(goods);

//        IGD.deleteGoodsById("000");

//        List<Goods> goodsList = IGD.findGoodsList();
//        System.out.println(goodsList);

//        List<Goods> goodsList = IGD.findGoodsListByCategory("电器");
//        System.out.println(goodsList);

//        List<Goods> goodsList = IGD.findGoodsListByPage(2);
//        System.out.println(goodsList);

//        Goods g = IGD.findGoodsById("4");
//        System.out.println(g);

//        IGD.updateGoodsPriceById(new BigDecimal("-1"), "4");

//        IGD.updateGoodsCountById(995,"4");

        IOrderDao IOD = new OrderDaoImpl();
//        Order order = new Order("999","000","11",1,0,new Date(),"快车","支付宝", new BigDecimal("1"));
//        IOD.addOrder(order);

//        IOD.deleteOrderById("999");

//        IOD.updateStatusById(1,"999");

//        System.out.println(IOD.findOrderList());

//        System.out.println(IOD.findOrderListByUserName("00"));

//        ICarDao ICC = new CarDaoImpl();
//        ICC.deleteCarById("admin","1", 4);

        String number = "11";
        Object json = JSONObject.toJSON(number);
        System.out.println(json);
    }



}
