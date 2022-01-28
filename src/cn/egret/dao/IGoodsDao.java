package cn.egret.dao;

import cn.egret.entity.Goods;

import java.math.BigDecimal;
import java.util.List;

public interface IGoodsDao {
    boolean addGoods(Goods goods); // 添加货品

    boolean deleteGoodsById(String id); // 删除货品

    List<Goods> findGoodsList(); // 查询所有货品列表

    List<Goods> findGoodsListByCategoryId(String categoryId, int curPage, int pageSize); // 通过类别ID查询货品列表

    List<Goods> findGoodsListByPage(int curPage, int pageSize); // 通过分页查询货品列表

    int findDataCount(String sql,Object... args); // 查询记录条数

    List<Goods> findGoodsLike(String key,int curPage, int pageSize); // 模糊查询

    Goods findGoodsById(String id); // 通过Id查询货品

    boolean updateGoodsPriceById(BigDecimal newPrice, String id); // 通过Id修改货品价格

    int findGoodsCountById(String id); // 获取货品数量

    boolean updateGoodsCountById(int newCount, String id); // 通过Id修改货品数量

}
