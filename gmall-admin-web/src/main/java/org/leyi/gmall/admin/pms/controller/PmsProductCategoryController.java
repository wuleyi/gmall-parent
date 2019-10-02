package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.mbg.pms.dto.PmsProductMultiCategoryDto;
import org.leyi.gmall.mbg.pms.dto.PmsProductMultiCategoryDto;
import org.leyi.gmall.mbg.pms.service.IProductCategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@Api("商品分类管理")
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Reference
    private IProductCategoryService productCategoryService;

    @GetMapping("/list/withChildren")
    public R listWithChildren(){

        List<PmsProductMultiCategoryDto> list = productCategoryService.listWithChildren();
        return R.ok(null).setCode(200);
    }

}
