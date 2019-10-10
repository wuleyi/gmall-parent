package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.pms.dto.PmsProductAttributeCategoryDto;
import org.leyi.gmall.pms.service.IProductAttributeCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api("商品属性分类管理")
@RequestMapping("/productAttribute/category")
@RestController
public class PmsProductAttributeCategoryController {

    @Reference
    private IProductAttributeCategoryService productAttributeCategoryService;

    @GetMapping("list")
    public R list(@RequestParam(value = "pageNum", defaultValue = "1") Long current,
                  @RequestParam(value = "pageSize", defaultValue = "5") Long size) {

        return R.ok(productAttributeCategoryService.pagePlus(current, size)).setCode(200);
    }

    @GetMapping("list/withAttr")
    public R getWithAttr(){

        List<PmsProductAttributeCategoryDto> list = productAttributeCategoryService.listWithAttr();
        return R.ok(list).setCode(200);
    }

}
