package org.leyi.gmall.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.ums.service.IMemberLevelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api("会员等级管理")
@RestController
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {

    @Reference
    private IMemberLevelService memberLevelService;

    @GetMapping("list")
    public R list(Integer defaultStatus) {

        return R.ok(memberLevelService.listByDefaultStatus(defaultStatus)).setCode(200);
    }

}
