package com.zhenai.service.goods;
import com.zhenai.entity.PageResult;
import com.zhenai.goods.Goods;
import com.zhenai.pojo.goods.Spu;

import java.util.*;

/**
 * spu业务逻辑层
 */
public interface SpuService {


    public List<Spu> findAll();


    public PageResult<Spu> findPage(int page, int size);


    public List<Spu> findList(Map<String, Object> searchMap);


    public PageResult<Spu> findPage(Map<String, Object> searchMap, int page, int size);


    public Spu findById(String id);

    public void add(Spu spu);


    public void update(Spu spu);


    public void delete(String id);

    /**
     * 保存商品
     * @param goods
     */
    public void saveGoods(Goods goods);

    /**
     * 根据商品编号查询商品信息
     * @param id
     * @return
     */
    Goods findGoodsById(String id);

    /**
     * 审核
     * @param id
     * @param status
     */
    public void audit(String id,String status,String message);
}
