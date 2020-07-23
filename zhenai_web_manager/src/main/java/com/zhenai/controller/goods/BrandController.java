package com.zhenai.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenai.entity.PageResult;
import com.zhenai.entity.Result;
import com.zhenai.pojo.goods.Brand;
import com.zhenai.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    //@RequestMapping(value = "",method = RequestMethod.GET)
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findPage")
    public PageResult<Brand> findPage(@RequestParam(name = "page",defaultValue = "1") int page,
                                      @RequestParam(name = "size",defaultValue = "5") int size){
        return brandService.findPage(page,size);
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String,Object> searchMap){
        return brandService.findList(searchMap);
    }

    /**
     * 条件分页查询
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/findPage")
    public PageResult<Brand> findPage(@RequestBody Map<String,Object> searchMap,
                                      @RequestParam(name = "page",defaultValue = "1") int page,
                                      @RequestParam(name = "size",defaultValue = "5") int size){
        return brandService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Brand findById(@RequestParam(name = "id") Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") Integer id){
        brandService.delete(id);
        return new Result();
    }

}
