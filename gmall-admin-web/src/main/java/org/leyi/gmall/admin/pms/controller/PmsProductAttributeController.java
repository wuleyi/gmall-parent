package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.pms.service.IProductAttributeCategoryService;
import org.leyi.gmall.pms.service.IProductAttributeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api("商品属性管理")
@RequestMapping("/productAttribute")
@RestController
public class PmsProductAttributeController {

    @Reference
    private IProductAttributeService productAttributeService;

    @Reference
    private IProductAttributeCategoryService productAttributeCategoryService;

    @GetMapping("list/{productAttributeCategoryId}")
    public R getByCategoryIdAndType(@PathVariable String productAttributeCategoryId,
                                    @RequestParam String type,
                                    @RequestParam(value="pageNum", defaultValue = "1") Long current,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Long size){

        return R.ok(productAttributeService.listByCategoryIdAndType(productAttributeCategoryId, type, current, size)).setCode(200);
    }

    @GetMapping("category/list")
    public R list(Long pageNum, Long pageSize){

        return R.ok(productAttributeCategoryService.pagePlus(pageNum, pageSize)).setCode(200);
    }

}
