package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.constant.ProductStatusConstant;
import org.leyi.gmall.pms.service.IProductService;
import org.leyi.gmall.pms.vo.PmsProductQuery;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api("商品管理")
@RestController
@RequestMapping("/product")
public class PmsProductController {

    @Reference
    private IProductService productService;

    @GetMapping("list")
    public R getByCondition(PmsProductQuery productQuery,
                 @RequestParam(value = "pageSize", defaultValue = "5") Long size,
                 @RequestParam(value="pageNum", defaultValue = "1") Long current){

        return R.ok(productService.listByCondition(productQuery, current, size)).setCode(200);
    }

    @PostMapping("update/publishStatus")
    public R updatePublishStatus(String ids, Integer publishStatus){

        return R.ok(productService.updateBatchProductStatus(ids, publishStatus, ProductStatusConstant.PUBLISH_STATUS)).setCode(200);
    }

    @PostMapping("update/deleteStatus")
    public R updateDeleteStatus(String ids, Integer deleteStatus){

        return R.ok(productService.updateBatchProductStatus(ids, deleteStatus, ProductStatusConstant.DELETE_STATUS)).setCode(200);
    }

    @PostMapping("update/newStatus")
    public R updateNewStatus(String ids, Integer newStatus){

        return R.ok(productService.updateBatchProductStatus(ids, newStatus, ProductStatusConstant.NEW_STATUS)).setCode(200);
    }

    @PostMapping("update/recommendStatus") // 原本为 update/recommandStatus, 前端写成 update/recommendStatus 了
    public R updateRecommandStatus(String ids, Integer recommendStatus){

        return R.ok(productService.updateBatchProductStatus(ids, recommendStatus, ProductStatusConstant.RECOMMAND_STATUS)).setCode(200);
    }

    @PostMapping("update/verifyStatus")
    public R updateVerifyStatus(String ids, Integer verifyStatus){

        return R.ok(productService.updateBatchProductStatus(ids, verifyStatus, ProductStatusConstant.VERIFY_STATUS)).setCode(200);
    }

}
