package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.mbg.pms.service.IProductService;
import org.leyi.gmall.mbg.pms.vo.PmsProductQuery;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api("商品管理")
@RestController
@RequestMapping("/product")
public class PmsProductController {

    @Reference
    private IProductService productService;

    @GetMapping("/list")
    public R get(PmsProductQuery productQuery,
                 @RequestParam(value = "pageSize", defaultValue = "5") Long size,
                 @RequestParam(value="pageNum", defaultValue = "1") Long current){

        return R.ok(productService.listByCondition(productQuery, current, size)).setCode(200);
    }

}
