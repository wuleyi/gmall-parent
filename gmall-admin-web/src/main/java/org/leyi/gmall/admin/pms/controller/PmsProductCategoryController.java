package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.pms.service.IProductCategoryService;
import org.leyi.gmall.pms.vo.PmsProductCategoryCreateVo;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api("商品分类管理")
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Reference
    private IProductCategoryService productCategoryService;

    @GetMapping("list/withChildren")
    public R getWithChildren() {

        return R.ok(productCategoryService.listWithChildren()).setCode(200);
    }

    @GetMapping("list/{parentId}")
    public R getByParentId(@PathVariable Long parentId,
                           @RequestParam(value = "pageNum", defaultValue = "1") Long current,
                           @RequestParam(value = "pageSize", defaultValue = "5") Long size) {

        return R.ok(productCategoryService.getByParentId(parentId, current, size)).setCode(200);
    }

    @PostMapping("create")
    public R createProductCategory(@RequestBody PmsProductCategoryCreateVo productCategoryCreateVo){

        return R.ok(productCategoryService.saveProductCategory(productCategoryCreateVo)).setCode(200);
    }

    @GetMapping("{id}")
    public R get(@PathVariable Long id){

        return R.ok(productCategoryService.getById(id)).setCode(200);
    }


}
