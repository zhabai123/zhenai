package com.zhenai.service.goods;

import com.zhenai.entity.PageResult;
import com.zhenai.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有的品牌
     * @return  品牌信息列表
     */
    List<Brand> findAll();

    /**
     * 分页查询
     * @param page  当前页码
     * @param size  每页显示的信息条数
     * @return      一页数据
     */
    PageResult<Brand> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    List<Brand> findList(Map<String, Object> searchMap);

    /**
     * 条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    void delete(Integer id);
}
