package org.leyi.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.leyi.gmall.mbg.pms.service.IBrandService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by leyi on 2019/6/9.
 */
@CrossOrigin
@Api("品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Reference
    private IBrandService brandService;

    @GetMapping("list")
    @ApiOperation("获取品牌列表")
    public R listBrand(@RequestParam(required = false) String keywords, Long pageNum, Long pageSize) {

        return R.ok(brandService.listByKeywords(keywords, pageNum, pageSize)).setCode(200);
    }

}
