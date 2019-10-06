package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.pms.service.IProductAttributeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api("商品属性管理")
@RequestMapping("/productAttribute")
@RestController
public class PmsProductAttributeController {

    @Reference
    private IProductAttributeService productAttributeService;

    @GetMapping("list/{productAttributeCategoryId}")
    public R getByCategoryIdAndType(@PathVariable String productAttributeCategoryId, @RequestParam String type){

        return R.ok(productAttributeService.listByCategoryIdAndType(productAttributeCategoryId, type)).setCode(200);
    }

}
