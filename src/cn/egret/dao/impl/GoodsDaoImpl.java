package cn.egret.dao.impl;

import cn.egret.dao.IGoodsCategoriesDao;
import cn.egret.dao.IGoodsDao;
import cn.egret.entity.Goods;
import cn.egret.entity.User;
import cn.egret.util.JdbcUtil;
import jdk.nashorn.internal.scripts.JD;

import java.math.BigDecimal;
import java.util.List;

public class GoodsDaoImpl implements IGoodsDao {
    @Override
    public boolean addGoods(Goods goods) {
        String sql = "insert into t_goods (id, name, description, price, img, count, categoryId) values(?,?,?,?,?,?,?)";
        int flag = JdbcUtil.update(sql, goods.getId(), goods.getName(), goods.getDescription(), goods.getPrice(), goods.getImg(), goods.getCount(), goods.getCategoryId());
        if (flag > 0) {
            System.out.println("添加货品成功");
            return true;
        } else {
            System.out.println("添加货品失败");
            return false;
        }
    }

    @Override
    public boolean deleteGoodsById(String id) {
        String sql = "delete from t_goods where id = ?";
        int flag = JdbcUtil.update(sql, id);
        if (flag > 0) {
            System.out.println("删除货品成功");
            return true;
        } else {
            System.out.println("删除货品失败");
            return false;
        }
    }

    @Override
    public List<Goods> findGoodsList() {
        String sql = "select * from t_goods";
        List<Goods> goodsList = JdbcUtil.queryAll(sql, Goods.class);
        return goodsList;
    }

    @Override
    public List<Goods> findGoodsListByCategoryId(String categoryId, int curPage, int pageSize) {
        String sql = "select * from t_goods where categoryId = ? limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<Goods> goodsList = JdbcUtil.queryAll(sql, Goods.class, categoryId, curPage, pageSize);
        return goodsList;
    }

    @Override
    public List<Goods> findGoodsListByPage(int curPage, int pageSize) {
        curPage = (curPage - 1) * pageSize;
        String sql = "select * from t_goods limit ?,?";
        List<Goods> goodsList = JdbcUtil.queryAll(sql, Goods.class, curPage, pageSize);
        return goodsList;
    }

    @Override
    public int findDataCount(String sql, Object... args) {
        return JdbcUtil.queryForCount(sql, args);
    }

    @Override
    public List<Goods> findGoodsLike(String key, int curPage, int pageSize) {
        String sql = "select * from t_goods where name like  \"%\"?\"%\" limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<Goods> goodsList = JdbcUtil.queryAll(sql, Goods.class, key, curPage, pageSize);

        return goodsList;
    }

    @Override
    public Goods findGoodsById(String id) {
        String sql = "select * from t_goods where id = ?";
        List<Goods> goodsList = JdbcUtil.queryAll(sql, Goods.class, id);
        Goods goods = null;
        for (Goods g : goodsList) {
            goods = g;
        }
        return goods;
    }

    @Override
    public boolean updateGoodsPriceById(BigDecimal newPrice, String id) {
        String sql = "update t_goods set price = ? where id = ?";
        int flag = JdbcUtil.update(sql, newPrice, id);
        if (flag > 0) {
            System.out.println("修改货品价格成功");
            return true;
        } else {
            System.out.println("修改货品价格失败");
            return false;
        }
    }

    @Override
    public int findGoodsCountById(String id) {
        Goods goods = findGoodsById(id);
        return goods.getCount();
    }

    @Override
    public boolean updateGoodsCountById(int newCount, String id) {
        String sql = "update t_goods set count = ? where id = ?";
        int flag = JdbcUtil.update(sql, newCount, id);
        if (flag > 0) {
            System.out.println("修改货品数量成功");
            return true;
        } else {
            System.out.println("修改货品数量失败");
            return false;
        }
    }
}
