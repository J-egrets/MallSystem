package cn.egret.service;

import cn.egret.dao.IGoodsCategoriesDao;
import cn.egret.dao.impl.GoodsCategoriesDaoImpl;
import cn.egret.entity.GoodsCategories;

public class GoodsCategoriesService {

    private static IGoodsCategoriesDao IGCD = new GoodsCategoriesDaoImpl();

    /**
     * 添加类别
     * @param gc
     * @return
     */
    public static boolean addCategory(GoodsCategories gc){
        return IGCD.addCategory(gc);
    }

    /**
     * 查询类别ID
     * @param name
     * @return
     */
    public static String findCategoryId(String name){
        return IGCD.findIdByName(name);
    }

    /**
     * 查询类别名字
     * @param id
     * @return
     */
    public static String findCategoryName(String id){
        return IGCD.findNameById(id);
    }

    /**
     * 删除类别
     * @param id
     * @return
     */
    public static boolean deleteCategory(String id){
        return IGCD.deleteCategoryById(id);
    }
}
