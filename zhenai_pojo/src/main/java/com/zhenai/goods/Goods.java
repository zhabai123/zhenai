package com.zhenai.goods;

import com.zhenai.pojo.goods.Sku;
import com.zhenai.pojo.goods.Spu;

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合实体类(spu和sku列表)
 */
public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
