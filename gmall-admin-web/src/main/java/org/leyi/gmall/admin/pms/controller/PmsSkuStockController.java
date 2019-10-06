package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.pms.entity.SkuStock;
import org.leyi.gmall.pms.service.ISkuStockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api("sku库存管理")
@RestController
@RequestMapping("/sku")
public class PmsSkuStockController {

    @Reference
    private ISkuStockService skuStockService;

    @GetMapping("{productId}")
    public R getByProductIdAndKeyword(@PathVariable String productId, @RequestParam(required = false) String keyword){

        return R.ok(skuStockService.listByProductIdAndKeyword(productId, keyword)).setCode(200);
    }

    @PostMapping("update/{productId}")
    public R update(@PathVariable String productId, @RequestBody List<SkuStock> skuStocks){

        return R.ok(skuStockService.updateBatch(skuStocks)).setCode(200);
    }

}
