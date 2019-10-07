package org.leyi.gmall.admin.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.cms.service.IPrefrenceAreaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api("关联优选管理")
@RestController
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    @Reference
    private IPrefrenceAreaService prefrenceAreaService;

    @GetMapping("listAll")
    public R get(){

        return R.ok(prefrenceAreaService.list()).setCode(200);
    }

}
