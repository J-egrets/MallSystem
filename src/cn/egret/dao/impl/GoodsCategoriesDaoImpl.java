package cn.egret.dao.impl;

import cn.egret.dao.IGoodsCategoriesDao;
import cn.egret.entity.GoodsCategories;
import cn.egret.util.JdbcUtil;

import java.util.List;

public class GoodsCategoriesDaoImpl implements IGoodsCategoriesDao {
    @Override
    public boolean addCategory(GoodsCategories gc) {
        String sql = "insert into t_goods_categories (id, name) values(?,?)";
        int flag = JdbcUtil.update(sql, gc.getId(), gc.getName());
        if (flag > 0) {
            System.out.println("添加类别成功");
            return true;
        } else {
            System.out.println("添加类别失败");
            return false;
        }
    }

    @Override
    public String findIdByName(String name) {
        String sql = "select * from t_goods_categories where name = ?";
        GoodsCategories gc = null;
        List<GoodsCategories> gcList = JdbcUtil.queryAll(sql,GoodsCategories.class,name);
        for(GoodsCategories gcg : gcList){
            gc = gcg;
        }
        if(gc != null){
            return gc.getId();
        }

        return null;
    }

    @Override
    public String findNameById(String id) {
        String sql = "select * from t_goods_categories where id = ?";
        GoodsCategories gc = null;
        List<GoodsCategories> gcList = JdbcUtil.queryAll(sql,GoodsCategories.class,id);
        for(GoodsCategories gcg : gcList){
            gc = gcg;
        }

        if(gc != null){
            return gc.getName();
        }

        return null;
    }

    @Override
    public boolean deleteCategoryById(String id) {
        String sql = "delete from t_goods_categories where id = ?";
        int flag = JdbcUtil.update(sql,id);
        if(flag > 0){
            System.out.println("删除类别成功");
            return true;
        }else{
            System.out.println("删除类别失败");
            return false;
        }
    }
}
