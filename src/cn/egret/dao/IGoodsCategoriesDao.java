package cn.egret.dao;

import cn.egret.entity.GoodsCategories;

public interface IGoodsCategoriesDao   {
    boolean addCategory(GoodsCategories gc); // 增加类别

    String findIdByName(String name); // 通过类别名查询类别Id

    String findNameById(String id); // 通过类别Id查询类别名

    boolean deleteCategoryById(String id); // 通过类别Id删除一个类别
}