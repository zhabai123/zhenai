package com.zhenai.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhenai.dao.BrandMapper;
import com.zhenai.entity.PageResult;
import com.zhenai.pojo.goods.Brand;
import com.zhenai.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPage(int page, int size) {
        //1.通过PageHelper开始分页（原理：通过拦截器来是实现了分页）
        PageHelper.startPage(page,size);
        //2.正常的查询
        Page<Brand> brands = (Page<Brand>)brandMapper.selectAll();
        //3.将一页信息结果返回
        return new PageResult<>(brands.getTotal(),brands.getResult());
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    private Example createExample(Map<String, Object> searchMap) {
        Example example =  new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap != null){
            //有name条件
            if(searchMap.get("name") != null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%" + (String)searchMap.get("name") + "%");
            }
            //有首字母
            if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter",(String)searchMap.get("letter"));
            }
        }
        return example;
    }

    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        //开始分页
        PageHelper.startPage(page,size);
        //执行条件查询
        Example example = createExample(searchMap);
        Page<Brand> brands = (Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult<Brand>(brands.getTotal(),brands.getResult());
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }


}
