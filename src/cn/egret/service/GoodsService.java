package cn.egret.service;

import cn.egret.dao.IGoodsDao;
import cn.egret.dao.impl.GoodsDaoImpl;
import cn.egret.entity.Goods;

import java.math.BigDecimal;
import java.util.List;

public class GoodsService {
    private static IGoodsDao IGD = new GoodsDaoImpl();

    /**
     * 添加货品
     *
     * @param goods
     * @return
     */
    public static Boolean addGoods(Goods goods) {
        return IGD.addGoods(goods);
    }

    /**
     * 删除货品
     *
     * @param id
     * @return
     */
    public static boolean deleteGoods(String id) {
        return IGD.deleteGoodsById(id);
    }

    /**
     * 查询所有货品列表
     *
     * @return
     */
    public static List<Goods> findGoodsList() {
        return IGD.findGoodsList();
    }

    /**
     * 通过类别ID查询货品列表
     *
     * @param categoryId
     * @param curPage
     * @param pageSize
     * @return
     */
    public static List<Goods> findGoodsList(String categoryId, int curPage, int pageSize) {
        return IGD.findGoodsListByCategoryId(categoryId, curPage, pageSize);
    }

    /**
     * 通过分页查询货品列表
     *
     * @param curPage
     * @param pageSize
     * @return
     */
    public static List<Goods> findGoodsList(int curPage, int pageSize) {
        return IGD.findGoodsListByPage(curPage, pageSize);
    }

    /**
     * 通过ID查询货品
     *
     * @param id
     * @return
     */
    public static Goods findGoods(String id) {
        return IGD.findGoodsById(id);
    }

    /**
     * 修改货品价格
     *
     * @param id
     * @param newPrice
     * @return
     */
    public static boolean changeGoodsPrice(String id, BigDecimal newPrice) {
        return IGD.updateGoodsPriceById(newPrice, id);
    }

    /**
     * 获取货品数量
     *
     * @param id
     * @return
     */
    public static int findGoodsCount(String id) {
        return IGD.findGoodsCountById(id);
    }

    /**
     * 修改货品数量
     *
     * @param id
     * @param newCount
     * @return
     */
    public static boolean changeGoodsCount(String id, int newCount) {
        return IGD.updateGoodsCountById(newCount, id);
    }

    /**
     * 查询记录数目
     *
     * @return
     */
    public static long findDataCount(String sql,Object... args) {
        return IGD.findDataCount(sql,args);
    }

    public static List<Goods> findGoodsLike(String key, int curPage, int pageSize){
        return IGD.findGoodsLike(key, curPage, pageSize);
    }
}
